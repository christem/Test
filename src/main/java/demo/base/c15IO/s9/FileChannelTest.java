package demo.base.c15IO.s9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Description: <br/>
 * Copyright (C), 2005-2008, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class FileChannelTest {
	public static void main(String[] args) {
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		try {
			File f = new File("FileChannelTest.java");
			// ����FileInputStream���Ը��ļ�����������FileChannel
			inChannel = new FileInputStream(f).getChannel();
			// ��FileChannel���ȫ������ӳ���ByteBuffer
			MappedByteBuffer buffer = inChannel.map(
					FileChannel.MapMode.READ_ONLY, 0, f.length());
			// ʹ��GBK���ַ���������������
			Charset charset = Charset.forName("GBK");
			// ���ļ����������FileBuffer�����Կ������
			outChannel = new FileOutputStream("a.txt").getChannel();
			// ֱ�ӽ�buffer�������ȫ�����
			outChannel.write(buffer);
			// �ٴε���buffer��clear()��������ԭlimit��position��λ��
			buffer.clear();
			// ����������(CharsetDecoder)����
			CharsetDecoder decoder = charset.newDecoder();
			// ʹ�ý�������ByteBufferת����CharBuffer
			CharBuffer charBuffer = decoder.decode(buffer);
			// CharBuffer��toString�������Ի�ȡ��Ӧ���ַ���
			System.out.println(charBuffer);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (inChannel != null)
					inChannel.close();
				if (outChannel != null)
					outChannel.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}