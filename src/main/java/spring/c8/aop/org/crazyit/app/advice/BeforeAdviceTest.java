package spring.c8.aop.org.crazyit.app.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

//����һ������
@Aspect
public class BeforeAdviceTest {
	// ƥ��spring.c8.before.org.crazyit.app.service.impl����������ġ�
	// ���з�����ִ����Ϊ�����
	// @Before("execution(* spring.c8.aop.org.crazyit.app.service.impl.*.*(..))")
	// public void authority() {
	// System.out.println("ģ�ⷽ����ʼǰ--ִ��Ȩ�޼��...");
	// }
	//
	// // ƥ��org.crazyit.app.service����������ġ�
	// // ���з�����ִ����Ϊ�����
	// @After("execution(* spring.c8.aop.org.crazyit.app.service.*.*(..))")
	// public void release() {
	// System.out.println("ģ�ⷽ��������--�ͷ���Դ...");
	// }
	//
	// // ƥ��org.crazyit.app.service.impl����������ġ�
	// // ���з�����ִ����Ϊ�����
	// @AfterReturning(returning = "rvt", pointcut =
	// "execution(* spring.c8.aop.org.crazyit.app.service.impl.*.*(..))")
	// public void log(Object rvt) {
	// System.out.println("��ȡĿ�귽������ֵ:" + rvt);
	// System.out.println("ģ���¼��־����...");
	// }

	// ƥ��org.crazyit.app.service.impl����������ġ�
	// ���з�����ִ����Ϊ����� @Around = @Before + @AfterReturning
	// �̰߳�ȫ��һ����Ŀ�귽��ִ��֮���֮����ĳ��״̬����
	@Around("execution(* spring.c8.aop.org.crazyit.app.service.impl.*.*(..))")
	public Object processTx(ProceedingJoinPoint jp) throws java.lang.Throwable {
		System.out.println("ִ��Ŀ�귽��֮ǰ��ģ�⿪ʼ����...");
		// ִ��Ŀ�귽����������Ŀ�귽��ִ�к�ķ���ֵ
		Object rvt = jp.proceed(new String[] { "���ı�Ĳ���" });
		System.out.println("ִ��Ŀ�귽��֮��ģ���������...");
		return rvt + " ����������";
	}
}
