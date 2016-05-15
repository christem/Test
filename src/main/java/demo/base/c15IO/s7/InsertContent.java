package demo.base.c15IO.s7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertContent {
	public static void insert(String fileName, long pos, String insertContent)
			throws IOException {
		RandomAccessFile raf = null;
		// ����һ����ʱ�ļ�����������������
		File tmp = File.createTempFile("tmp", null);
		FileOutputStream tmpOut = null;
		FileInputStream tmpIn = null;
		tmp.deleteOnExit();
		try {
			raf = new RandomAccessFile(fileName, "rw");
			tmpOut = new FileOutputStream(tmp);
			tmpIn = new FileInputStream(tmp);
			raf.seek(pos);
			// --------������뽫����������ݶ�����ʱ�ļ��б���---------
			byte[] bbuf = new byte[64];
			// ���ڱ���ʵ�ʶ�ȡ���ֽ���
			int hasRead = 0;
			// ʹ��ѭ����ʽ��ȡ�����������
			while ((hasRead = raf.read(bbuf)) > 0) {
				// ����ȡ������д����ʱ�ļ�
				tmpOut.write(bbuf, 0, hasRead);
			}
			// ----------��������������----------
			// ���ļ���¼ָ�����¶�λ��posλ��
			raf.seek(pos);
			// ׷����Ҫ���������
			raf.write(insertContent.getBytes());
			// ׷����ʱ�ļ��е�����
			while ((hasRead = tmpIn.read(bbuf)) > 0) {
				raf.write(bbuf, 0, hasRead);
			}
		} finally {
			raf.close();
		}
	}

	public static void main(String[] args) throws IOException {
		insert("InsertContent.java", 45, "���������\r\n");
	}
}
