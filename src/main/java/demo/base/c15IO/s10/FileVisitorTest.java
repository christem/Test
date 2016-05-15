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
		// 遍历g:\publish\codes\15目录下的所有文件和子目录
		Files.walkFileTree(
				Paths.get("E:/Code/MyGitProject/Test/src/main/java/demo/base/",
						"c15IO/"), new SimpleFileVisitor<Path>() {
					// 访问文件时候触发该方法
					@Override
					public FileVisitResult visitFile(Path file,
							BasicFileAttributes attrs) throws IOException {
						System.out.println("正在访问" + file + "文件");
						// 找到了FileInputStreamTest.java文件
						if (file.endsWith("FileInputStreamTest.java")) {
							System.out.println("--已经找到目标文件--");
							return FileVisitResult.TERMINATE;
						}
						return FileVisitResult.CONTINUE;
					}

					// 开始访问目录时触发该方法
					@Override
					public FileVisitResult preVisitDirectory(Path dir,
							BasicFileAttributes attrs) throws IOException {
						System.out.println("正在访问：" + dir + " 路径");
						return FileVisitResult.CONTINUE;
					}
				});
	}
}
