package demo.base.c15IO.s6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromProcess {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			// 运行javac命令，返回运行该命令的子进程
			Process p = Runtime.getRuntime().exec("javac");
			// 以p进程的错误流创建BufferedReader对象（这个错误流对本程序是输入流，对p进程则是输出流）
			br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			String buff = null;
			// 采取循环方式来读取p进程的错误输出
			while ((buff = br.readLine()) != null) {
				System.out.println(buff);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
