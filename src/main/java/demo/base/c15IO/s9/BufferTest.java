package demo.base.c15IO.s9;

import java.nio.CharBuffer;

public class BufferTest {
	public static void main(String[] args) {
		// 创建Buffer
		CharBuffer buff = CharBuffer.allocate(8); // 1
		System.out.println("capacity: " + buff.capacity());// 8
		System.out.println("limit: " + buff.limit());// 8
		System.out.println("position: " + buff.position());// 0
		// 放入元素
		buff.put('a'); // 0
		buff.put('b'); // 1
		buff.put('c'); // 2

		System.out.println("加入三个元素后，position = " + buff.position());// 3
		// 调用flip()方法
		buff.flip(); // 5
		System.out.println("执行flip()后，limit = " + buff.limit());// 3
		System.out.println("position = " + buff.position());// 0
		// 取出第一个元素
		System.out.println("第一个元素（position=0）：" + buff.get()); // a
		System.out.println("取出一个元素后，position = " + buff.position());// 1
		// 调用clear方法
		buff.clear(); // 7
		System.out.println("执行clear()后，limit = " + buff.limit());// 8
		System.out.println("执行clear()后，position = " + buff.position());// 0
		System.out.println("执行clear()后，缓冲区内容并没有被清除：" + buff.get(2)); // c
		System.out.println("执行绝对读取后，position = " + buff.position());// 0
	}
}