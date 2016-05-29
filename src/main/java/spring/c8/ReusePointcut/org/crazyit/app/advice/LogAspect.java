package spring.c8.ReusePointcut.org.crazyit.app.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogAspect {
	// 直接使用SystemArchitecture切面类的myPointcut切入点
	// args(msg)保证该切入点只匹配只有一个字符串参数的方法
	@AfterReturning(pointcut = "SystemArchitecture.myPointcut()"
			+ "&&args(msg)", returning = "retVal")
	public void writeLog(String msg, Object retVal) {
		System.out.println(msg);
		System.out.println(retVal);
		System.out.println("模拟记录日志....");
	}
}
