package demo.base.c15IO.s7;

import java.io.IOException;
import java.io.RandomAccessFile;

public class AppendContent {
	public static void main(String[] args) {
		RandomAccessFile raf = null;
		try {
			// �Զ���д��ʽ��һ��RandomAccessFile����
			raf = new RandomAccessFile(
					"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s7/out.txt",
					"rw");
			// ����¼ָ���ƶ���out.txt�ļ������
			raf.seek(raf.length());
			raf.write("׷�ӵ����ݣ�\r\n".getBytes());
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (raf != null) {
					raf.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}
