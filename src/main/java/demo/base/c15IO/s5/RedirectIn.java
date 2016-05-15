package demo.base.c15IO.s5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class RedirectIn {
	public static void main(String[] args) {
		FileInputStream fis = null;
		Scanner sc = null;
		try {
			fis = new FileInputStream(
					"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s5/RedirectIn.java");
			// ����׼�����ض���fis������
			System.setIn(fis);
			// ʹ��System.in����Scanner�������ڻ�ȡ��׼����
			sc = new Scanner(System.in);
			// ��������һ�н�ֻ�ѻس���Ϊ�ָ���
			sc.useDelimiter("\n");
			// �ж��Ƿ�����һ��������
			while (sc.hasNext()) {
				// ���������
				System.out.println("��������������ǣ�" + sc.next());
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					sc.close();
					fis.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
