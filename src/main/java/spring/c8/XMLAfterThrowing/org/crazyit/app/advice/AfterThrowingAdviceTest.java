package spring.c8.XMLAfterThrowing.org.crazyit.app.advice;

public class AfterThrowingAdviceTest {
	// ����һ����ͨ������Ϊ��ǿ������
	public void doRecoveryActions(Throwable ex) {
		// ex����Ŀ�귽�����׳����쳣
		System.out.println("Ŀ�귽�����׳����쳣:" + ex);
		System.out.println("ģ���׳��쳣�����Դ����...");
	}
}
