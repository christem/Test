package demo.base.c15IO.s7;

import java.io.IOException;
import java.io.RandomAccessFile;

public class AppendContent {
	public static void main(String[] args) {
		RandomAccessFile raf = null;
		try {
			// 以读、写方式打开一个RandomAccessFile对象
			raf = new RandomAccessFile(
					"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s7/out.txt",
					"rw");
			// 将记录指针移动的out.txt文件的最后
			raf.seek(raf.length());
			raf.write("追加的内容！\r\n".getBytes());
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
