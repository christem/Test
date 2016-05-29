package spring.c8.ReusePointcut.org.crazyit.app.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemArchitecture {
	@Pointcut("execution(* spring.c8.ReusePointcut.org.crazyit.app.service.impl.*.say*(..))")
	public void myPointcut() {
		System.out.println("SystemArchitecture:");
	}
}
