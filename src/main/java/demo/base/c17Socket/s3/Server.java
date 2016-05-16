package demo.base.c17Socket.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		// ����һ��ServerSocket�����ڼ����ͻ���Socket����������
		ServerSocket ss = new ServerSocket(30000);
		// ����ѭ�����Ͻ������Կͻ��˵�����
		while (true) {
			// ÿ�����ܵ��ͻ���Socket�����󣬷�������Ҳ��Ӧ����һ��Socket
			Socket s = ss.accept();
			// ��Socket��Ӧ���������װ��PrintStream
			PrintStream ps = new PrintStream(s.getOutputStream());
			// ������ͨIO����
			ps.println("���ã����յ��˷�����������ף����");

			BufferedReader br = new BufferedReader(new InputStreamReader(
					s.getInputStream()));
			// ������ͨIO����
			String line = br.readLine();
			System.out.println("���Կͻ��˵����ݣ�" + line);

			// �ر���������ر�Socket
			ps.close();
			s.close();
		}
	}
}
