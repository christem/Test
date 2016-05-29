package spring.c8.ReusePointcut.org.crazyit.app.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogAspect {
	// ֱ��ʹ��SystemArchitecture�������myPointcut�����
	// args(msg)��֤�������ֻƥ��ֻ��һ���ַ��������ķ���
	@AfterReturning(pointcut = "SystemArchitecture.myPointcut()"
			+ "&&args(msg)", returning = "retVal")
	public void writeLog(String msg, Object retVal) {
		System.out.println(msg);
		System.out.println(retVal);
		System.out.println("ģ���¼��־....");
	}
}
