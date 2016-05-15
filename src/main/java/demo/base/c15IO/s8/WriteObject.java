package demo.base.c15IO.s8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		try {
			// ����һ��ObjectOutputStream�����
			oos = new ObjectOutputStream(
					new FileOutputStream(
							"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s8/object.txt"));
			Person per1 = new Person("��ɮ", 30);
			Person per2 = new Person("�����", 1000);
			Person per3 = new Person("��˽�", 500);
			Person per4 = new Person("ɳɮ", 500);
			// ��per����д�������
			oos.writeObject(per1);
			oos.writeObject(per2);
			oos.writeObject(per3);
			oos.writeObject(per4);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (oos != null)
					oos.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
