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
package com.phei.netty.c2.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * @author Administrator
 * @date 2014年2月16日
 * @version 1.0
 */
public class AsyncTimeServerHandler implements Runnable {

	private int port;

	CountDownLatch latch;
	AsynchronousServerSocketChannel asynchronousServerSocketChannel;

	public AsyncTimeServerHandler(int port) {
		this.port = port;
		try {
			// 创建一个异步的服务端通道AsynchronousServerSocketChannel，然后绑定端口
			asynchronousServerSocketChannel = AsynchronousServerSocketChannel
					.open();
			asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
			System.out.println("The time server is start in port : " + port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// 初始化CountDownLatch对象
		// 作用让线程在此阻塞，防止服务器执行完成退出
		latch = new CountDownLatch(1);
		doAccept();
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void doAccept() {
		// 通过AcceptCompletionHandler实例作为handler来接收通知消息
		asynchronousServerSocketChannel.accept(this,
				new AcceptCompletionHandler());
	}

}
