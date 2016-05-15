package demo.base.c15IO.s9;

import java.nio.charset.Charset;
import java.util.SortedMap;

public class CharsetTest {
	public static void main(String[] args) {
		// ��ȡȫ���ַ���
		SortedMap<String, Charset> map = Charset.availableCharsets();
		for (String alias : map.keySet()) {
			// ����ַ����ı����Ͷ�Ӧ��Charset����
			System.out.println(alias + "----->" + map.get(alias));
		}
	}
}
