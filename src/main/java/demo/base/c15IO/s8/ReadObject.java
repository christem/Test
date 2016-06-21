package demo.base.c15IO.s8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {
    public static void main(String[] args) {
	ObjectInputStream ois = null;
	try {
	    // ����һ��ObjectInputStream�����
	    ois = new ObjectInputStream(new FileInputStream(
		    "E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s8/object.txt"));

	    boolean flag = true;
	    while (flag) {

		Object obj = ois.readObject();
		if (obj != null) {
		    // ���������ж�ȡһ��Java���󣬲�����ǿ������ת��ΪPerson��
		    Person p = (Person) obj;
		    System.out.println("����Ϊ��" + p.getName() + "\n����Ϊ��" + p.getAge());
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
