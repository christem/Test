package demo.base.c17Socket.s3.MultiThread.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author yeeku.H.lee kongyeeku@163.com
 * @version 1.0 <br>
 *          Copyright (C), 2005-2008, yeeku.H.Lee <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: <br>
 *          Date:
 */
public class MyClient {
	public static void main(String[] args) throws IOException {
		Socket s = s = new Socket("127.0.0.1", 30000);
		// �ͻ�������ClientThread�̲߳��϶�ȡ���Է�����������
		new Thread(new ClientThread(s)).start();
		// ��ȡ��Socket��Ӧ�������
		PrintStream ps = new PrintStream(s.getOutputStream());
		String line = null;
		// ���϶�ȡ��������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while ((line = br.readLine()) != null) {
			// ���û��ļ�����������д��Socket��Ӧ�������
			ps.println(line);
		}
	}
}
