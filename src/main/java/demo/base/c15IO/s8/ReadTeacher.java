package demo.base.c15IO.s8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadTeacher {
	public static void main(String[] args) {
		ObjectInputStream ois = null;
		try {
			// 创建一个ObjectInputStream输入流
			ois = new ObjectInputStream(
					new FileInputStream(
							"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s8/teacher.txt"));
			// 依次读取ObjectInputStream输入流中的四个对象
			Teacher t1 = (Teacher) ois.readObject();
			Teacher t2 = (Teacher) ois.readObject();
			Person p = (Person) ois.readObject();
			Teacher t3 = (Teacher) ois.readObject();
			// 输出true
			System.out.println("t1的student引用和p是否相同：" + (t1.getStudent() == p));
			// 输出true
			System.out.println("t2的student引用和p是否相同：" + (t2.getStudent() == p));
			// 输出true
			System.out.println("t2和t3是否是同一个对象：" + (t2 == t3));
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
