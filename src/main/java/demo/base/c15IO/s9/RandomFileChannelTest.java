package demo.base.c15IO.s9;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class RandomFileChannelTest {
	public static void main(String[] args) {
		FileChannel randomChannel = null;
		try {
			File f = new File(
					"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s9/a.txt");
			// ����һ��RandomAccessFile����
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			// ��ȡRandomAccessFile��Ӧ��Channel
			randomChannel = raf.getChannel();
			// ��Channel����������ӳ���ByteBuffer
			ByteBuffer buffer = randomChannel.map(
					FileChannel.MapMode.READ_ONLY, 0, f.length());
			// ��Channel�ļ�¼ָ���ƶ������
			randomChannel.position(f.length());
			// ��buffer�������������
			randomChannel.write(buffer);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (randomChannel != null)
					randomChannel.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
