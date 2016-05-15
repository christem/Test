package demo.base.c15IO.s3;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
	public static void main(String[] args) throws IOException {
		FileReader fr = null;
		try {
			// �����ַ�������
			fr = new FileReader(
					"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s3/FileReaderTest.java");
			// ����һ������Ϊ32�ġ���Ͳ��
			char[] cbuf = new char[32];
			// ���ڱ���ʵ�ʶ�ȡ���ַ���
			int hasRead = 0;
			int total = 0;
			// ʹ��ѭ�����ظ���ȡˮ������
			while ((hasRead = fr.read(cbuf)) > 0) {
				total += hasRead;
				// ȡ������Ͳ����ˮ�Σ��ֽڣ������ַ�����ת�����ַ������룡
				System.out.print(new String(cbuf, 0, hasRead));
			}
			System.out.print("�ܹ��У�" + total);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			// ʹ��finally�����ر��ļ�������
			if (fr != null) {
				fr.close();
			}
		}
	}
}
