package demo.base.c15IO.s4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {
	public static void main(String[] args) throws IOException {
		PrintStream ps = null;
		try {
			// 创建一个节点输出流：FileOutputStream
			FileOutputStream fos = new FileOutputStream(
					"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s4/test.txt");
			// 以PrintStream来包装FileOutputStream输出流
			ps = new PrintStream(fos);
			// 使用PrintStream执行输出
			ps.println("普通字符串");
			ps.println(new PrintStreamTest());
		} catch (IOException ioe) {
			ioe.printStackTrace(ps);
		} finally {
			ps.close();
		}
	}
}
