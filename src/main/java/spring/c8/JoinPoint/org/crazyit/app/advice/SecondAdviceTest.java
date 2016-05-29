package spring.c8.JoinPoint.org.crazyit.app.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

//����һ������
@Aspect
@Order(1)
// ֵԽС���ȼ�Խ��
public class SecondAdviceTest {
	// ����Before��ǿ����ִ��
	@Before("execution(* spring.c8.JoinPoint.org.crazyit.app.service.impl.*.*(..))")
	public void zuthority(JoinPoint jp) {
		System.out.println("�ź�Before��ǿ��ģ��ִ��Ȩ�޼��");
	}

	// // �����args(msg,time)��֤�������ֻƥ��
	// // ���е�һ���������ַ������ڶ���������Date�ķ���
	// @AfterReturning(pointcut =
	// "execution(* spring.c8.JoinPoint.org.crazyit.app.service.impl"
	// + ".*.*(..)) && args(food , ..)", returning = "retVal")
	// public void access(String food, Object retVal) {
	// System.out.println("Ŀ�귽����String����Ϊ��" + food);
	// System.out.println("ģ���¼��־....");
	// }
}
