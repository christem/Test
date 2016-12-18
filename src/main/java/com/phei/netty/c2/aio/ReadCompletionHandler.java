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
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author lilinfeng
 * @date 2014年2月16日
 * @version 1.0
 */
public class ReadCompletionHandler implements
		CompletionHandler<Integer, ByteBuffer> {

	private AsynchronousSocketChannel channel;

	public ReadCompletionHandler(AsynchronousSocketChannel channel) {
		if (this.channel == null)
			this.channel = channel;
	}

	// 用于读取半包消息和发送应答
	@Override
	public void completed(Integer result, ByteBuffer attachment) {
		attachment.flip();// 读准备
		// 根据缓冲区的可读字节数创建byte数组
		byte[] body = new byte[attachment.remaining()];
		attachment.get(body);
		try {
			// 通过new String 方法创建请求消息
			String req = new String(body, "UTF-8");
			System.out.println("The time server receive order : " + req);
			// 对请求消息进行判断
			String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(req) ? new java.util.Date(
					System.currentTimeMillis()).toString() : "BAD ORDER";
			// 调用方法发送给客户端
			doWrite(currentTime);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private void doWrite(String currentTime) {
		if (currentTime != null && currentTime.trim().length() > 0) {
			byte[] bytes = (currentTime).getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);
			writeBuffer.flip();
			channel.write(writeBuffer, writeBuffer,
					new CompletionHandler<Integer, ByteBuffer>() {
						@Override
						public void completed(Integer result, ByteBuffer buffer) {
							// 如果没有发送完成，继续发送
							if (buffer.hasRemaining())
								channel.write(buffer, buffer, this);
						}

						@Override
						public void failed(Throwable exc, ByteBuffer attachment) {
							try {
								channel.close();
							} catch (IOException e) {
								// ingnore on close
							}
						}
					});
		}
	}

	// 发生异常时，对异常Throwable进行判断
	// 一般处理 如果是IO异常就关闭链路，释放资源 如果是其他异常按照业务的逻辑进行处理
	@Override
	public void failed(Throwable exc, ByteBuffer attachment) {
		try {
			this.channel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
