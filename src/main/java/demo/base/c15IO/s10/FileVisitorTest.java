package demo.base.c15IO.s10;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorTest {
	public static void main(String[] args) throws Exception {
		// ����g:\publish\codes\15Ŀ¼�µ������ļ�����Ŀ¼
		Files.walkFileTree(
				Paths.get("E:/Code/MyGitProject/Test/src/main/java/demo/base/",
						"c15IO/"), new SimpleFileVisitor<Path>() {
					// �����ļ�ʱ�򴥷��÷���
					@Override
					public FileVisitResult visitFile(Path file,
							BasicFileAttributes attrs) throws IOException {
						System.out.println("���ڷ���" + file + "�ļ�");
						// �ҵ���FileInputStreamTest.java�ļ�
						if (file.endsWith("FileInputStreamTest.java")) {
							System.out.println("--�Ѿ��ҵ�Ŀ���ļ�--");
							return FileVisitResult.TERMINATE;
						}
						return FileVisitResult.CONTINUE;
					}

					// ��ʼ����Ŀ¼ʱ�����÷���
					@Override
					public FileVisitResult preVisitDirectory(Path dir,
							BasicFileAttributes attrs) throws IOException {
						System.out.println("���ڷ��ʣ�" + dir + " ·��");
						return FileVisitResult.CONTINUE;
					}
				});
	}
}
