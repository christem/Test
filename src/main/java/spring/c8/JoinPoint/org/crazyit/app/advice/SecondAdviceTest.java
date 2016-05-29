package spring.c8.JoinPoint.org.crazyit.app.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

//定义一个切面
@Aspect
@Order(1)
// 值越小优先级越高
public class SecondAdviceTest {
	// 定义Before增强处理执行
	@Before("execution(* spring.c8.JoinPoint.org.crazyit.app.service.impl.*.*(..))")
	public void zuthority(JoinPoint jp) {
		System.out.println("⑴号Before增强：模拟执行权限检查");
	}

	// // 下面的args(msg,time)保证该切入点只匹配
	// // 具有第一个参数是字符串，第二个参数是Date的方法
	// @AfterReturning(pointcut =
	// "execution(* spring.c8.JoinPoint.org.crazyit.app.service.impl"
	// + ".*.*(..)) && args(food , ..)", returning = "retVal")
	// public void access(String food, Object retVal) {
	// System.out.println("目标方法中String参数为：" + food);
	// System.out.println("模拟记录日志....");
	// }
}
