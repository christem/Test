package demo.base.c15IO.s5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class RedirectOut {
	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			ps = new PrintStream(
					new FileOutputStream(
							"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s5/out.txt"));
			// ����׼����ض���ps�����
			System.setOut(ps);
			// ���׼������һ���ַ���
			System.out.println("��ͨ�ַ���");
			// ���׼������һ������
			System.out.println(new RedirectOut());
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
	}
}
