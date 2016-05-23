package demo.base.c15IO.s9;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class BufferTest {
    public static void testCharBuffer() {
	// ����CharBuffer
	CharBuffer buff = CharBuffer.allocate(8); // 1
	System.out.println("capacity: " + buff.capacity());// 8
	System.out.println("limit: " + buff.limit());// 8
	System.out.println("position: " + buff.position());// 0
	// ����Ԫ��
	buff.put('a'); // 0
	buff.put('b'); // 1
	buff.put('c'); // 2

	System.out.println("��������Ԫ�غ�position = " + buff.position());// 3
	// ����flip()����
	buff.flip(); // 5
	System.out.println("ִ��flip()��limit = " + buff.limit());// 3
	System.out.println("position = " + buff.position());// 0
	// ȡ����һ��Ԫ��
	System.out.println("��һ��Ԫ�أ�position=0����" + buff.get()); // a
	System.out.println("ȡ��һ��Ԫ�غ�position = " + buff.position());// 1
	// ����clear����
	buff.clear(); // 7
	System.out.println("ִ��clear()��limit = " + buff.limit());// 8
	System.out.println("ִ��clear()��position = " + buff.position());// 0
	System.out.println("ִ��clear()�󣬻��������ݲ�û�б������" + buff.get(2)); // c
	System.out.println("ִ�о��Զ�ȡ��position = " + buff.position());// 0
    }

    public static void testByteBuffer() {
	// ����ByteBuffer
	ByteBuffer buff = ByteBuffer.allocate(8); // 1
	System.out.println("capacity: " + buff.capacity());// 8
	System.out.println("limit: " + buff.limit());// 8
	System.out.println("position: " + buff.position());// 0
	// ����Ԫ��
	buff.put((byte) 'a'); // 0
	buff.put((byte) 'b'); // 1
	buff.put((byte) 'c'); // 2

	System.out.println("��������Ԫ�غ�position = " + buff.position());// 3
	// ����flip()����
	buff.flip(); // 5
	System.out.println("ִ��flip()��limit = " + buff.limit());// 3
	System.out.println("position = " + buff.position());// 0
	// ȡ����һ��Ԫ��
	System.out.println("��һ��Ԫ�أ�position=0����" + buff.get()); // 97
	System.out.println("ȡ��һ��Ԫ�غ�position = " + buff.position());// 1
	// ����clear����
	buff.clear(); // 7
	System.out.println("ִ��clear()��limit = " + buff.limit());// 8
	System.out.println("ִ��clear()��position = " + buff.position());// 0
	System.out.println("ִ��clear()�󣬻��������ݲ�û�б������" + buff.get(2)); // 99
	System.out.println("ִ�о��Զ�ȡ��position = " + buff.position());// 0
    }

    public static void test3() {
	// ����CharBuffer
	CharBuffer buff = CharBuffer.allocate(8); // 1
	System.out.println("capacity: " + buff.capacity());// 8
	System.out.println("limit: " + buff.limit());// 8
	System.out.println("position: " + buff.position());// 0
	// ����Ԫ��
	buff.put('a'); // 0
	buff.put('b'); // 1
	buff.put('c'); // 2
	buff.put('d'); // 3
	buff.put('e'); // 4

	System.out.println("��������Ԫ�غ�position = " + buff.position());// 3
	// ����flip()����
	buff.flip(); // 5
	System.out.println("ִ��flip()��limit = " + buff.limit());// 3
	System.out.println("position = " + buff.position());// 0
	// ȡ����һ��Ԫ��
	System.out.println("��һ��Ԫ�أ�position=0����" + buff.get()); // a
	System.out.println("ȡ��һ��Ԫ�غ�position = " + buff.position());// 1
	// buff.flip(); // 5
	System.out.println("��һ��Ԫ�أ�position=0����" + buff.get());
	buff.clear();
	int count = buff.remaining();
	for (int i = 0; i < count; i++) {
	    System.out.println("�ڣ�" + i + "��Ԫ��" + buff.get());
	}
	buff.clear();
	buff.put('h');
	buff.put('i');
	buff.put('g');
	buff.flip();
	while (buff.hasRemaining()) {
	    System.out.println("Ԫ��:" + buff.get());
	}
	System.out.println("ֱ�ӻ�ȡԪ��:" + buff.get(1));
    }

    public static void main(String[] args) {
	// testCharBuffer();
	// testByteBuffer();
	// test3();
	// ****************************************************
	// ����
	// CharBuffer charBuffer = CharBuffer.wrap("Hello World");
	// System.out.println(charBuffer);
	// System.out.println(charBuffer.length());

	// //Duplicate()����������һ����ԭʼ���������Ƶ��»�������������������������Ԫ�أ�ӵ��ͬ������������ÿ��������ӵ�и��Ե�λ�ã��Ͻ�ͱ�����ԡ���һ���������ڵ�����Ԫ�������ĸı�ᷴӳ������һ���������ϡ�
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
	// ������븴�����ƣ���slice()����һ����ԭʼ�������ĵ�ǰλ�ÿ�ʼ���»�������������������ԭʼ��������ʣ��Ԫ��������limit-position��������»�������ԭʼ����������һ������Ԫ�������С��ָ�����Ļ�����Ҳ��̳�ֻ����ֱ�����ԡ�
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
	// wrap����bufferΪֻ����˻ᱨ��java.nio.ReadOnlyBufferException
	// buffer2.put('a');

	// ****************************************************
	// // ����ռ�
	// CharBuffer buffer = CharBuffer.allocate(16);
	// // ����Ԫ��
	// buffer.put('a').put('b').put('c').put('d').put('e').put('f').put('g');
	// System.out.println("1 position:" + buffer.position());
	// System.out.println("1 limit:" + buffer.limit());
	// // ��ת
	// buffer.flip();
	// // ��ȡ��ǰԪ��
	// System.out.println(buffer.get());
	//
	// System.out.println("2 position:" + buffer.position());
	// System.out.println("2 limit:" + buffer.limit());
	//
	// // ��ȡ��0��Ԫ��
	// System.out.println(buffer.get(0));
	// System.out.println("3 position:" + buffer.position());
	// System.out.println("3 limit:" + buffer.limit());
	//
	// // ��ȡ��5��Ԫ��
	// System.out.println(buffer.get(5));
	// System.out.println("4 position:" + buffer.position());
	// System.out.println("4 limit:" + buffer.limit());
	//
	// // �������ռ�
	// buffer.clear();
	// // ��ѯ����ռ��С
	// System.out.println(buffer.remaining());
	// // ��������
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