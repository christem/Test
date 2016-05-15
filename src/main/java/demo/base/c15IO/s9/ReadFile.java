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
			// 创建文件输入流
			fis = new FileInputStream(
					"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s9/ReadFile.java");
			// 创建一个FileChannel
			fcin = fis.getChannel();
			// 定义一个ByteBuffer对象，用于重复取水
			ByteBuffer bbuff = ByteBuffer.allocate(1024);
			// 将FileChannel中数据放入ByteBuffer中
			while (fcin.read(bbuff) != -1) {
				// 锁定Buffer的空白区
				bbuff.flip();
				// 创建Charset对象
				Charset charset = Charset.forName("gb2312");
				// 创建解码器(CharsetDecoder)对象
				CharsetDecoder decoder = charset.newDecoder();
				// 将ByteBuffer的内容转码
				CharBuffer cbuff = decoder.decode(bbuff);
				System.out.println(cbuff);
				// 将Buffer初始化，为下一次取数据做准备
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
