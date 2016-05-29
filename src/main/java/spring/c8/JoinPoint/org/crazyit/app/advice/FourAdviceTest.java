package spring.c8.JoinPoint.org.crazyit.app.advice;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

//����һ������
@Aspect
@Order(2)
// ֵԽС���ȼ�Խ��
public class FourAdviceTest {
	// // ����Around��ǿ����ִ��
	// @Around("execution(* spring.c8.JoinPoint.org.crazyit.app.service.impl.*.*(..))")
	// public Object processTx(ProceedingJoinPoint jp) throws
	// java.lang.Throwable {
	// System.out.println("Around��ǿ��ִ��Ŀ�귽��֮ǰ��ģ�⿪ʼ����...");
	// // ����ִ��Ŀ�귽���Ĳ���
	// Object[] args = jp.getArgs();
	// // ��ִ��Ŀ�귽���Ĳ������ڣ�
	// // �ҵ�һ���������ַ�������
	// if (args != null && args.length > 0
	// && args[0].getClass() == String.class) {
	// // �ı��һ��Ŀ�귽���ĵ�һ������
	// args[0] = "���ı�Ĳ���";
	// }
	// // ִ��Ŀ�귽����������Ŀ�귽��ִ�к�ķ���ֵ
	// Object rvt = jp.proceed(args);
	// System.out.println("Around��ǿ��ִ��Ŀ�귽��֮��ģ���������...");
	// return rvt + " ����������";
	// }
	//
	// // ����Before��ǿ����ִ��
	// @Before("execution(* spring.c8.JoinPoint.org.crazyit.app.service.impl.*.*(..))")
	// public void authority(JoinPoint jp) {
	// System.out.println("Before��ǿ��ģ��ִ��Ȩ�޼��");
	// // ���ر�֯����ǿ�����Ŀ�귽��
	// System.out.println("Before��ǿ����֯����ǿ�����Ŀ�귽��Ϊ��"
	// + jp.getSignature().getName());
	// // ����ִ��Ŀ�귽���Ĳ���
	// System.out
	// .println("Before��ǿ��Ŀ�귽���Ĳ���Ϊ��" + Arrays.toString(jp.getArgs()));
	// // ���ʱ���ǿ�����Ŀ�����
	// System.out.println("Before��ǿ����֯����ǿ�����Ŀ�����Ϊ��" + jp.getTarget());
	// }
	//
	// // ����AfterReturning��ǿ����ִ��
	// @AfterReturning(pointcut =
	// "execution(* spring.c8.JoinPoint.org.crazyit.app.service.impl.*.*(..))",
	// returning = "rvt")
	// public void log(JoinPoint jp, Object rvt) {
	// System.out.println("AfterReturning��ǿ����ȡĿ�귽������ֵ:" + rvt);
	// System.out.println("AfterReturning��ǿ��ģ���¼��־����...");
	// // ���ر�֯����ǿ�����Ŀ�귽��
	// System.out.println("AfterReturning��ǿ����֯����ǿ�����Ŀ�귽��Ϊ��"
	// + jp.getSignature().getName());
	// // ����ִ��Ŀ�귽���Ĳ���
	// System.out.println("AfterReturning��ǿ��Ŀ�귽���Ĳ���Ϊ��"
	// + Arrays.toString(jp.getArgs()));
	// // ���ʱ���ǿ�����Ŀ�����
	// System.out.println("AfterReturning��ǿ����֯����ǿ�����Ŀ�����Ϊ��" + jp.getTarget());
	// }
	//
	// // ����After��ǿ����ִ��
	// @After("execution(* spring.c8.JoinPoint.org.crazyit.app.service.impl.*.*(..))")
	// public void release(JoinPoint jp) {
	// System.out.println("After��ǿ��ģ�ⷽ����������ͷ���Դ...");
	// // ���ر�֯����ǿ�����Ŀ�귽��
	// System.out.println("After��ǿ����֯����ǿ�����Ŀ�귽��Ϊ��"
	// + jp.getSignature().getName());
	// // ����ִ��Ŀ�귽���Ĳ���
	// System.out.println("After��ǿ��Ŀ�귽���Ĳ���Ϊ��" + Arrays.toString(jp.getArgs()));
	// // ���ʱ���ǿ�����Ŀ�����
	// System.out.println("After��ǿ����֯����ǿ�����Ŀ�����Ϊ��" + jp.getTarget());
	// }
}
