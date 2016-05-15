package demo.base.c15IO.s8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeMutable {
	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			// 创建一个ObjectOutputStream输入流
			oos = new ObjectOutputStream(
					new FileOutputStream(
							"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s8/mutable.txt"));

			ois = new ObjectInputStream(
					new FileInputStream(
							"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s8/mutable.txt"));

			Person per = new Person("孙悟空", 500);
			// 系统会per对象转换字节序列并输出
			oos.writeObject(per);
			per.setName("猪八戒");

			oos.writeObject(per);
			Person test = new Person("沙僧", 500);
			oos.writeObject(test);
			Person per1 = (Person) ois.readObject();
			Person per2 = (Person) ois.readObject();
			Person per3 = (Person) ois.readObject();

			System.out.println(per1 == per2);
			System.out.println(per2.getName());
			System.out.println(per3.getName());
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
				if (oos != null)
					oos.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
