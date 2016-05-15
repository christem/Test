package demo.base.c15IO.s10;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest {
	public static void main(String[] args) throws Exception {
		String path = "E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s10/";

		// �����ļ�
		Files.copy(Paths.get(path + "FilesTest.java"), new FileOutputStream(
				path + "a.txt"));
		// �ж�FilesTest.java�ļ��Ƿ�Ϊ�����ļ�
		System.out.println("FilesTest.java�Ƿ�Ϊ�����ļ���"
				+ Files.isHidden(Paths.get(path + "FilesTest.java")));
		// һ���Զ�ȡFilesTest.java�ļ���������
		List<String> lines = Files.readAllLines(
				Paths.get(path + "FilesTest.java"), Charset.forName("gbk"));
		System.out.println(lines);
		// �ж�ָ���ļ��Ĵ�С
		System.out.println("FilesTest.java�Ĵ�СΪ��"
				+ Files.size(Paths.get(path + "FilesTest.java")));
		List<String> poem = new ArrayList<String>();
		poem.add("ˮ��̶������Ծ");
		poem.add("������б̸ͺ�");
		// ֱ�ӽ�����ַ�������д��ָ���ļ���
		Files.write(Paths.get(path + "pome.txt"), poem, Charset.forName("gbk"));
		FileStore cStore = Files.getFileStore(Paths.get("C:"));
		// �ж�C�̵��ܿռ䣬���ÿռ�
		System.out.println("C:���пռ䣺" + cStore.getTotalSpace());
		System.out.println("C:���ÿռ䣺" + cStore.getUsableSpace());
	}
}
