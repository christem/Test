package demo.base.c15IO.s4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {
	public static void main(String[] args) throws IOException {
		PrintStream ps = null;
		try {
			// ����һ���ڵ��������FileOutputStream
			FileOutputStream fos = new FileOutputStream(
					"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s4/test.txt");
			// ��PrintStream����װFileOutputStream�����
			ps = new PrintStream(fos);
			// ʹ��PrintStreamִ�����
			ps.println("��ͨ�ַ���");
			ps.println(new PrintStreamTest());
		} catch (IOException ioe) {
			ioe.printStackTrace(ps);
		} finally {
			ps.close();
		}
	}
}
