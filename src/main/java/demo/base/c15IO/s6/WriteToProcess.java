package demo.base.c15IO.s6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class WriteToProcess {
	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			// ����java ReadStandard����������и�������ӽ���
			Process p = Runtime.getRuntime().exec("java ReadStandard");
			// ��p���̵����������PrintStream����
			// ���������Ա����������������p����������������
			ps = new PrintStream(p.getOutputStream());
			// ��ReadStandard����д�����ݣ���Щ���ݽ���ReadStandard��ȡ
			ps.println("��ͨ�ַ���");
			ps.println(new WriteToProcess());
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (ps != null)
				ps.close();
		}
	}
}

// ����һ��ReadStandard�࣬������Խ��ܱ�׼���룬
// ������׼����д��out.txt�ļ���
class ReadStandard {
	public static void main(String[] args) throws Exception {

		// ʹ��System.in����Scanner�������ڻ�ȡ��׼����
		Scanner sc = new Scanner(System.in);
		PrintStream ps = new PrintStream(
				new FileOutputStream(
						"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s6/out.txt"));
		// ��������һ�н�ֻ�ѻس���Ϊ�ָ���
		sc.useDelimiter("\n");
		// �ж��Ƿ�����һ��������
		while (sc.hasNext()) {
			// ���������
			ps.println("��������������ǣ�" + sc.next());
		}
		ps.close();
	}
}
