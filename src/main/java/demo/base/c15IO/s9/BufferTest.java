package demo.base.c15IO.s9;

import java.nio.CharBuffer;

public class BufferTest {
	public static void main(String[] args) {
		// ����Buffer
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
}