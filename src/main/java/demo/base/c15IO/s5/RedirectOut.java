package demo.base.c15IO.s5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class RedirectOut {
	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			ps = new PrintStream(
					new FileOutputStream(
							"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s5/out.txt"));
			// 将标准输出重定向到ps输出流
			System.setOut(ps);
			// 向标准输出输出一个字符串
			System.out.println("普通字符串");
			// 向标准输出输出一个对象
			System.out.println(new RedirectOut());
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
	}
}
