package demo.base.c16Thread.s6.piped;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Description: <br/>
 * Copyright (C), 2008-2010, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
class ReaderThread extends Thread {
	private PipedReader pr;
	// ���ڰ�װ�ܵ�����BufferReader����
	private BufferedReader br;

	public ReaderThread() {
	}

	public ReaderThread(PipedReader pr) {
		this.pr = pr;
		this.br = new BufferedReader(pr);
	}

	public void run() {
		String buf = null;
		try {
			// ���ж�ȡ�ܵ��������е�����
			while ((buf = br.readLine()) != null) {
				System.out.println(buf);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		// ʹ��finally�����ر�������
		finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}

class WriterThread extends Thread {
	String[] books = new String[] { "Struts2Ȩ��ָ��", "ROR���ݿ���ָ��",
			"����J2EE��Ajax����", "������J2EE��ҵӦ��ָ��" };
	private PipedWriter pw;

	public WriterThread() {
	}

	public WriterThread(PipedWriter pw) {
		this.pw = pw;
	}

	public void run() {
		try {
			// ѭ��100�Σ���ܵ��������д��100���ַ�
			for (int i = 0; i < 100; i++) {
				pw.write(books[i % 4] + "\n");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		// ʹ��finally�����رչܵ������
		finally {
			try {
				if (pw != null) {
					pw.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}

public class PipedCommunicationTest {
	public static void main(String[] args) {
		PipedWriter pw = null;
		PipedReader pr = null;
		try {
			// �ֱ𴴽����������Ĺܵ��������������
			pw = new PipedWriter();
			pr = new PipedReader();
			// ���ӹܵ��������������
			pw.connect(pr);

			// �����ӺõĹܵ����ֱ���2���̣߳�
			// �Ϳ����������߳�ͨ��ܵ�������ͨ��
			new WriterThread(pw).start();
			new ReaderThread(pr).start();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
