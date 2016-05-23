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
	// ****************************************************
	// 复制
	// CharBuffer charBuffer = CharBuffer.wrap("Hello World");
	// System.out.println(charBuffer);
	// System.out.println(charBuffer.length());

	// //Duplicate()函数创建了一个与原始缓冲区相似的新缓冲区。两个缓冲区共享数据元素，拥有同样的容量，但每个缓冲区拥有各自的位置，上界和标记属性。对一个缓冲区内的数据元素所做的改变会反映在另外一个缓冲区上。
	// CharBuffer buffer1 = CharBuffer.allocate(8);
	// buffer1.position(3).limit(6).mark().position(5);
	// CharBuffer buffer2 = buffer1.duplicate();
	// buffer1.position(4);
	// buffer1.clear();
	//
	// System.out.println("1 position:" + buffer1.position());
	// System.out.println("1 limit:" + buffer1.limit());
	//
	// System.out.println("2 position:" + buffer2.position());
	// System.out.println("2 limit:" + buffer2.limit());
	// ****************************************************
	// 割缓冲区与复制相似，但slice()创建一个从原始缓冲区的当前位置开始的新缓冲区，并且其容量是原始缓冲区的剩余元素数量（limit-position）。这个新缓冲区与原始缓冲区共享一段数据元素子序列。分割出来的缓冲区也会继承只读和直接属性。
	CharBuffer buffer1 = CharBuffer.wrap("Hello World");
	// buffer1.flip();
	System.out.println("1 position:" + buffer1.position());
	System.out.println("1 limit:" + buffer1.limit());
	System.out.println("1 capacity:" + buffer1.capacity());
	buffer1.clear();
	buffer1.position(3).limit(8);
	CharBuffer buffer2 = buffer1.slice();
	System.out.println(buffer1);

	System.out.println("3 position:" + buffer1.position());
	System.out.println("3 limit:" + buffer1.limit());
	System.out.println("3 capacity:" + buffer1.capacity());

	System.out.println("2 position:" + buffer2.position());
	System.out.println("2 limit:" + buffer2.limit());
	System.out.println("2 capacity:" + buffer2.capacity());
	System.out.println(buffer2);

	buffer2.clear();
	// wrap创建buffer为只读因此会报错java.nio.ReadOnlyBufferException
	// buffer2.put('a');

	// ****************************************************
	// // 分配空间
	// CharBuffer buffer = CharBuffer.allocate(16);
	// // 放入元素
	// buffer.put('a').put('b').put('c').put('d').put('e').put('f').put('g');
	// System.out.println("1 position:" + buffer.position());
	// System.out.println("1 limit:" + buffer.limit());
	// // 翻转
	// buffer.flip();
	// // 获取当前元素
	// System.out.println(buffer.get());
	//
	// System.out.println("2 position:" + buffer.position());
	// System.out.println("2 limit:" + buffer.limit());
	//
	// // 获取第0个元素
	// System.out.println(buffer.get(0));
	// System.out.println("3 position:" + buffer.position());
	// System.out.println("3 limit:" + buffer.limit());
	//
	// // 获取第5个元素
	// System.out.println(buffer.get(5));
	// System.out.println("4 position:" + buffer.position());
	// System.out.println("4 limit:" + buffer.limit());
	//
	// // 清除缓存空间
	// buffer.clear();
	// // 查询缓存空间大小
	// System.out.println(buffer.remaining());
	// // 复制数组
	// char[] test = new char[32];
	// System.out.println(buffer.get(test, 0, buffer.remaining()));
	// System.out.println(new String(test));
	//
	// System.out.println("5 position:" + buffer.position());
	// System.out.println("5 limit:" + buffer.limit());
	// System.out.println(buffer.hasArray());
	// char[] testArray = buffer.array();
	// System.out.println(new String(testArray));
	// System.out.println(testArray.length);
    }
}