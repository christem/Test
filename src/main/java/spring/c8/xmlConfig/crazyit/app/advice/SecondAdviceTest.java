package spring.c8.xmlConfig.crazyit.app.advice;

import org.springframework.stereotype.Component;

@Component
public class SecondAdviceTest {
	// ����Before��ǿ����
	public void authority(String aa) {
		System.out.println("Ŀ�귽���Ĳ���Ϊ��" + aa);
		System.out.println("�ٺ�Before��ǿ��ģ��ִ��Ȩ�޼��");
	}
}
