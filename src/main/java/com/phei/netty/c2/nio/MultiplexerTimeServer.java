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
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Administrator
 * @date 2014年2月16日
 * @version 1.0
 */
public class MultiplexerTimeServer implements Runnable {

	private Selector selector;

	private ServerSocketChannel servChannel;

	private volatile boolean stop;

	/**
	 * 初始化多路复用器、绑定监听端口
	 * 
	 * @param port
	 */
	public MultiplexerTimeServer(int port) {
		try {
			// 1.打开ServerSocketChannel 监听客户端连接
			servChannel = ServerSocketChannel.open();
			// 2.绑定端口 设置为非阻塞
			servChannel.configureBlocking(false);
			servChannel.socket().bind(new InetSocketAddress(port), 1024);
			// 3.创建Selector，启动线程
			selector = Selector.open();
			// 4.将ServerSocketChannel注册到selector 监听
			servChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("The time server is start in port : " + port);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void stop() {
		this.stop = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// 5.多路复用器在线程run方法的无限循环体内轮询准备就绪的key
		while (!stop) {
			try {
				selector.select(1000);// 每隔1s唤醒一次
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
			} catch (Throwable t) {
				t.printStackTrace();
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
			// 处理新接入的请求消息
			if (key.isAcceptable()) {
				ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
				// 6.多路复用器监听到有新的客户端接入，处理新的接入请求，
				// 完成TCP三次握手建立物理链路
				SocketChannel sc = ssc.accept();
				// 7.设置客户端连接为非阻塞模式
				sc.configureBlocking(false);
				// 8将新接入的客户端连接注册到多路复用器上，监听读操作，
				// 用来读取客户端发送的网络消息
				sc.register(selector, SelectionKey.OP_READ);
			}
			if (key.isReadable()) {
				// Read the data
				SocketChannel sc = (SocketChannel) key.channel();
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				// 9异步读取客户端请求消息到缓冲区
				int readBytes = sc.read(readBuffer);
				// 10对ByteBuffer进行编解码
				if (readBytes > 0) {
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new String(bytes, "UTF-8");
					System.out.println("The time server receive order : "
							+ body);
					String currentTime = "QUERY TIME ORDER"
							.equalsIgnoreCase(body) ? new java.util.Date(
							System.currentTimeMillis()).toString()
							: "BAD ORDER";
					doWrite(sc, currentTime);
				} else if (readBytes < 0) {
					// 对端链路关闭
					key.cancel();
					sc.close();
				} else
					; // 读到0字节，忽略
			}
		}
	}

	private void doWrite(SocketChannel channel, String response)
			throws IOException {
		if (response != null && response.trim().length() > 0) {
			byte[] bytes = response.getBytes();// 讲字符串编码成数组
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);// 将数组设置缓冲区
			writeBuffer.flip();
			// 11将POJO对象encode成ByteBuffer
			// 调用SocketChannel的异步write接口，将消息异步发送给客户端
			channel.write(writeBuffer);
		}
	}
}
