package demo.base.c15IO.s1;

import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterTest {
	public static void main(String[] args) {
		File file = new File(".");
		String[] nameList = file.list(new MyFilenameFilter());
		for (String name : nameList) {
			System.out.println(name);
		}
	}
}

// ʵ���Լ���FilenameFilterʵ����
class MyFilenameFilter implements FilenameFilter {
	public boolean accept(File dir, String name) {
		// ����ļ�����.java��β�������ļ���Ӧһ��·��������true
		boolean flag = name.endsWith(".java") || new File(name).isDirectory();
		return flag;
	}
}
