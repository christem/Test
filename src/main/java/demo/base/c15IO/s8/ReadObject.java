package demo.base.c15IO.s8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {
    public static void main(String[] args) {
	ObjectInputStream ois = null;
	try {
	    // 创建一个ObjectInputStream输出流
	    ois = new ObjectInputStream(new FileInputStream(
		    "E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s8/object.txt"));

	    boolean flag = true;
	    while (flag) {

		Object obj = ois.readObject();
		if (obj != null) {
		    // 从输入流中读取一个Java对象，并将其强制类型转换为Person类
		    Person p = (Person) obj;
		    System.out.println("名字为：" + p.getName() + "\n年龄为：" + p.getAge());
		} else {
		    flag = false;
		}

	    }
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
