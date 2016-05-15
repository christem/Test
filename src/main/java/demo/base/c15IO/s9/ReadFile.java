package demo.base.c15IO.s9;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ReadFile {
	public static void main(String[] args) {
		FileChannel fcin = null;
		FileInputStream fis = null;
		try {
			// �����ļ�������
			fis = new FileInputStream(
					"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s9/ReadFile.java");
			// ����һ��FileChannel
			fcin = fis.getChannel();
			// ����һ��ByteBuffer���������ظ�ȡˮ
			ByteBuffer bbuff = ByteBuffer.allocate(1024);
			// ��FileChannel�����ݷ���ByteBuffer��
			while (fcin.read(bbuff) != -1) {
				// ����Buffer�Ŀհ���
				bbuff.flip();
				// ����Charset����
				Charset charset = Charset.forName("gb2312");
				// ����������(CharsetDecoder)����
				CharsetDecoder decoder = charset.newDecoder();
				// ��ByteBuffer������ת��
				CharBuffer cbuff = decoder.decode(bbuff);
				System.out.println(cbuff);
				// ��Buffer��ʼ����Ϊ��һ��ȡ������׼��
				bbuff.clear();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {

			try {
				if (fcin != null)
					fcin.close();
				fis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}
	}
}
