package demo.base.c15IO.s9;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class BufferTest {
    public static void testCharBuffer() {
	// 创建CharBuffer
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

    public static void testByteBuffer() {
	// 创建ByteBuffer
	ByteBuffer buff = ByteBuffer.allocate(8); // 1
	System.out.println("capacity: " + buff.capacity());// 8
	System.out.println("limit: " + buff.limit());// 8
	System.out.println("position: " + buff.position());// 0
	// 放入元素
	buff.put((byte) 'a'); // 0
	buff.put((byte) 'b'); // 1
	buff.put((byte) 'c'); // 2

	System.out.println("加入三个元素后，position = " + buff.position());// 3
	// 调用flip()方法
	buff.flip(); // 5
	System.out.println("执行flip()后，limit = " + buff.limit());// 3
	System.out.println("position = " + buff.position());// 0
	// 取出第一个元素
	System.out.println("第一个元素（position=0）：" + buff.get()); // 97
	System.out.println("取出一个元素后，position = " + buff.position());// 1
	// 调用clear方法
	buff.clear(); // 7
	System.out.println("执行clear()后，limit = " + buff.limit());// 8
	System.out.println("执行clear()后，position = " + buff.position());// 0
	System.out.println("执行clear()后，缓冲区内容并没有被清除：" + buff.get(2)); // 99
	System.out.println("执行绝对读取后，position = " + buff.position());// 0
    }

    public static void test3() {
	// 创建CharBuffer
	CharBuffer buff = CharBuffer.allocate(8); // 1
	System.out.println("capacity: " + buff.capacity());// 8
	System.out.println("limit: " + buff.limit());// 8
	System.out.println("position: " + buff.position());// 0
	// 放入元素
	buff.put('a'); // 0
	buff.put('b'); // 1
	buff.put('c'); // 2
	buff.put('d'); // 3
	buff.put('e'); // 4

	System.out.println("加入三个元素后，position = " + buff.position());// 3
	// 调用flip()方法
	buff.flip(); // 5
	System.out.println("执行flip()后，limit = " + buff.limit());// 3
	System.out.println("position = " + buff.position());// 0
	// 取出第一个元素
	System.out.println("第一个元素（position=0）：" + buff.get()); // a
	System.out.println("取出一个元素后，position = " + buff.position());// 1
	// buff.flip(); // 5
	System.out.println("第一个元素（position=0）：" + buff.get());
	buff.clear();
	int count = buff.remaining();
	for (int i = 0; i < count; i++) {
	    System.out.println("第：" + i + "个元素" + buff.get());
	}
	buff.clear();
	buff.put('h');
	buff.put('i');
	buff.put('g');
	buff.flip();
	while (buff.hasRemaining()) {
	    System.out.println("元素:" + buff.get());
	}
	System.out.println("直接获取元素:" + buff.get(1));
    }

    public static void main(String[] args) {
	// testCharBuffer();
	// testByteBuffer();
	// test3();

	CharBuffer buffer = CharBuffer.allocate(16);
	buffer.put('a').put('b').put('c').put('d').put('e').put('f').put('g');
	System.out.println("1 position:" + buffer.position());
	System.out.println("1 limit:" + buffer.limit());
	buffer.flip();
	System.out.println(buffer.get());

	System.out.println("2 position:" + buffer.position());
	System.out.println("2 limit:" + buffer.limit());

	System.out.println(buffer.get(0));
	System.out.println("3 position:" + buffer.position());
	System.out.println("3 limit:" + buffer.limit());

	System.out.println(buffer.get(5));
	System.out.println("4 position:" + buffer.position());
	System.out.println("4 limit:" + buffer.limit());

	buffer.clear();
	System.out.println(buffer.remaining());
	char[] test = new char[32];
	System.out.println(buffer.get(test, 0, buffer.remaining()));
	System.out.println(new String(test));

	System.out.println("5 position:" + buffer.position());
	System.out.println("5 limit:" + buffer.limit());
    }
}