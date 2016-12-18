/*
 * Copyright 2013-2018 Lilinfeng.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.phei.netty.c2.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Administrator
 * @date 2014年2月16日
 * @version 1.0
 */
public class TimeClientHandle implements Runnable {

	private String host;
	private int port;

	private Selector selector;
	private SocketChannel socketChannel;

	private volatile boolean stop;

	public TimeClientHandle(String host, int port) {
		this.host = host == null ? "127.0.0.1" : host;
		this.port = port;
		try {
			// 1.打开SocketChannel，绑定客户端本地地址
			socketChannel = SocketChannel.open();
			// 2.设置SocketChannel为非阻塞模式 同时设置客户端连接的TCP参数
			socketChannel.configureBlocking(false);
			// 创建Selector，启动线程
			selector = Selector.open();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void run() {
		try {
			doConnect();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		// 7.多路复用器在线程run方法的无限循环体内轮询准备就绪的key
		while (!stop) {
			try {
				selector.select(1000);
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> it = selectedKeys.iterator();
				SelectionKey key = null;
				while (it.hasNext()) {
					key = it.next();
					it.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						if (key != null) {
							key.cancel();
							if (key.channel() != null)
								key.channel().close();
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}

		// 多路复用器关闭后，所有注册在上面的Channel和Pipe等资源都会被自动去注册并关闭，所以不需要重复释放资源
		if (selector != null)
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

	}

	private void handleInput(SelectionKey key) throws IOException {

		if (key.isValid()) {
			// 判断是否连接成功
			SocketChannel sc = (SocketChannel) key.channel();
			// 8.接收connec时间进行处理
			if (key.isConnectable()) {
				// 9.判断连接结果，如果连接成功，注册读事件到多路复用器
				if (sc.finishConnect()) {
					// 10.判断连接结果，如果连接成功，注册读事件到多路复用器
					sc.register(selector, SelectionKey.OP_READ);
					doWrite(sc);
				} else
					System.exit(1);// 连接失败，进程退出
			}
			if (key.isReadable()) {
				// 11 异步读客户端请求到缓冲区
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int readBytes = sc.read(readBuffer);
				if (readBytes > 0) {
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					// 对ByteBuffer进行编解码
					String body = new String(bytes, "UTF-8");
					System.out.println("Now is : " + body);
					this.stop = true;
				} else if (readBytes < 0) {
					// 对端链路关闭
					key.cancel();
					sc.close();
				} else
					; // 读到0字节，忽略
			}
		}

	}

	private void doConnect() throws IOException {
		// 3.异步连接服务器 如果直接连接成功，则注册到多路复用器上，发送请求消息，读应答
		boolean connected = socketChannel.connect(new InetSocketAddress(host,
				port));
		// 4.判断是否连接成功
		if (connected) {// 成功，则直接注册读状态到多路复用器中
			socketChannel.register(selector, SelectionKey.OP_READ);
			doWrite(socketChannel);
		} else
			// 失败，则false，说明客户端已经发送sync包，服务端没有返回ack包，物理连接没有建立
			// 向多路复用器注册OP_CONNECT状态为，监听服务端的TCP_ACK应答
			socketChannel.register(selector, SelectionKey.OP_CONNECT);
	}

	private void doWrite(SocketChannel sc) throws IOException {
		byte[] req = "QUERY TIME ORDER".getBytes();
		ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
		writeBuffer.put(req);
		writeBuffer.flip();
		// 调用SocketChannel的异步write接口，将消息异步发送给客户端
		sc.write(writeBuffer);
		if (!writeBuffer.hasRemaining())
			System.out.println("Send order 2 server succeed.");
	}

}
