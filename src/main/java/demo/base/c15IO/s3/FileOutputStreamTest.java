package demo.base.c15IO.s3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			// 创建字节输入流
			fis = new FileInputStream(
					"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s3/FileOutputStreamTest.java");
			// 创建字节输入流
			fos = new FileOutputStream(
					"./src/main/java/demo/base/c15IO/s3/newFile.txt");
			byte[] bbuf = new byte[32];
			int hasRead = 0;
			int total = 0;
			// 循环从输入流中取出数据
			while ((hasRead = fis.read(bbuf)) > 0) {
				total += hasRead;
				// 每读取一次，即写入文件输出流，读了多少，就写多少。
				fos.write(bbuf, 0, hasRead);
			}
			System.out.print("总共有：" + total);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			// 使用finally块来关闭文件输入流
			if (fis != null) {
				fis.close();
			}
			// 使用finally块来关闭文件输出流
			if (fos != null) {
				fos.close();
			}
		}
	}
}
