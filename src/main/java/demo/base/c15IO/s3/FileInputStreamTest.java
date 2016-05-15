package demo.base.c15IO.s3;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
	public static void main(String[] args) throws IOException {
		// �����ֽ�������
		FileInputStream fis = new FileInputStream(
				"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s3/FileInputStreamTest.java");
		// ����һ������Ϊ1024�ġ���Ͳ��
		byte[] bbuf = new byte[1024];
		// ���ڱ���ʵ�ʶ�ȡ���ֽ���
		int hasRead = 0;
		int total = 0;
		// ʹ��ѭ�����ظ���ȡˮ������
		while ((hasRead = fis.read(bbuf)) > 0) {

			total += hasRead;

			// ȡ������Ͳ����ˮ�Σ��ֽڣ������ֽ�����ת�����ַ������룡
			System.out.print(new String(bbuf, 0, hasRead));
		}
		System.out.print("�ܹ��У�" + total);
		fis.close();
	}
}
