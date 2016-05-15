package demo.base.c15IO.s3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			// �����ֽ�������
			fis = new FileInputStream(
					"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s3/FileOutputStreamTest.java");
			// �����ֽ�������
			fos = new FileOutputStream(
					"./src/main/java/demo/base/c15IO/s3/newFile.txt");
			byte[] bbuf = new byte[32];
			int hasRead = 0;
			int total = 0;
			// ѭ������������ȡ������
			while ((hasRead = fis.read(bbuf)) > 0) {
				total += hasRead;
				// ÿ��ȡһ�Σ���д���ļ�����������˶��٣���д���١�
				fos.write(bbuf, 0, hasRead);
			}
			System.out.print("�ܹ��У�" + total);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			// ʹ��finally�����ر��ļ�������
			if (fis != null) {
				fis.close();
			}
			// ʹ��finally�����ر��ļ������
			if (fos != null) {
				fos.close();
			}
		}
	}
}
