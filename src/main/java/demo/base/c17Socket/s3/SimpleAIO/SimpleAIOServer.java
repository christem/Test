package demo.base.c17Socket.s3.SimpleAIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.Future;

public class SimpleAIOServer {
	static final int PORT = 30000;

	public static void main(String[] args) throws Exception {

		// ���ڶ�ȡ���ݵ�ByteBuffer��
		ByteBuffer buff = ByteBuffer.allocate(1024);

		try (
		// �ٴ���AsynchronousServerSocketChannel����
		AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel
				.open()) {
			// ��ָ����ָ����ַ���˿ڼ�����
			serverChannel.bind(new InetSocketAddress(PORT));
			while (true) {
				// �۲���ѭ���������Կͻ��˵�����
				Future<AsynchronousSocketChannel> future = serverChannel
						.accept();
				// ��ȡ������ɺ󷵻ص�AsynchronousSocketChannel ����ʱIO�������������
				AsynchronousSocketChannel socketChannel = future.get();
				// ִ�������
				socketChannel.write(
						ByteBuffer.wrap("��ӭ������AIO�����磡".getBytes("UTF-8")))
						.get();
				socketChannel.read(buff).get();
				buff.flip();
				// ��buff������ת��Ϊ�ַ���
				String content = Charset.forName("UTF-8").decode(buff)
						.toString();
				System.out.println("�ͻ�����Ϣ��" + content);
			}
		}
	}
}
