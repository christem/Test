package demo.base.c15IO.s6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromProcess {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			// ����javac����������и�������ӽ���
			Process p = Runtime.getRuntime().exec("javac");
			// ��p���̵Ĵ���������BufferedReader��������������Ա�����������������p���������������
			br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			String buff = null;
			// ��ȡѭ����ʽ����ȡp���̵Ĵ������
			while ((buff = br.readLine()) != null) {
				System.out.println(buff);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
