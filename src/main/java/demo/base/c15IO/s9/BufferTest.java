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