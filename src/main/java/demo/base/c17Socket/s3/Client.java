package demo.base.c17Socket.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException {
		Socket socket = null;
		socket = new Socket("127.0.0.1", 30000);
		// ��Socket��Ӧ����������װ��BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		// ������ͨIO����
		String line = br.readLine();
		System.out.println("���Է����������ݣ�" + line);

		PrintStream ps = new PrintStream(socket.getOutputStream());
		// ������ͨIO����
		ps.println("����client��������֣�");
		// �ر���������socket
		br.close();
		socket.close();

	}
}
