package demo.base.c15IO.s8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Description: <br/>
 * Copyright (C), 2005-2008, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class ReadTeacher {
	public static void main(String[] args) {
		ObjectInputStream ois = null;
		try {
			// ����һ��ObjectInputStream������
			ois = new ObjectInputStream(new FileInputStream("teacher.txt"));
			// ���ζ�ȡObjectInputStream�������е��ĸ�����
			Teacher t1 = (Teacher) ois.readObject();
			Teacher t2 = (Teacher) ois.readObject();
			Person p = (Person) ois.readObject();
			Teacher t3 = (Teacher) ois.readObject();
			// ���true
			System.out.println("t1��student���ú�p�Ƿ���ͬ��" + (t1.getStudent() == p));
			// ���true
			System.out.println("t2��student���ú�p�Ƿ���ͬ��" + (t2.getStudent() == p));
			// ���true
			System.out.println("t2��t3�Ƿ���ͬһ������" + (t2 == t3));
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