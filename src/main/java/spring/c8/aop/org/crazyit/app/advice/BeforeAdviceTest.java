package spring.c8.aop.org.crazyit.app.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

//定义一个切面
@Aspect
public class BeforeAdviceTest {
	// 匹配spring.c8.before.org.crazyit.app.service.impl包下所有类的、
	// 所有方法的执行作为切入点
	// @Before("execution(* spring.c8.aop.org.crazyit.app.service.impl.*.*(..))")
	// public void authority() {
	// System.out.println("模拟方法开始前--执行权限检查...");
	// }
	//
	// // 匹配org.crazyit.app.service包下所有类的、
	// // 所有方法的执行作为切入点
	// @After("execution(* spring.c8.aop.org.crazyit.app.service.*.*(..))")
	// public void release() {
	// System.out.println("模拟方法结束后--释放资源...");
	// }
	//
	// // 匹配org.crazyit.app.service.impl包下所有类的、
	// // 所有方法的执行作为切入点
	// @AfterReturning(returning = "rvt", pointcut =
	// "execution(* spring.c8.aop.org.crazyit.app.service.impl.*.*(..))")
	// public void log(Object rvt) {
	// System.out.println("获取目标方法返回值:" + rvt);
	// System.out.println("模拟记录日志功能...");
	// }

	// 匹配org.crazyit.app.service.impl包下所有类的、
	// 所有方法的执行作为切入点 @Around = @Before + @AfterReturning
	// 线程安全，一般在目标方法执行之后和之后共享某种状态数据
	@Around("execution(* spring.c8.aop.org.crazyit.app.service.impl.*.*(..))")
	public Object processTx(ProceedingJoinPoint jp) throws java.lang.Throwable {
		System.out.println("执行目标方法之前，模拟开始事务...");
		// 执行目标方法，并保存目标方法执行后的返回值
		Object rvt = jp.proceed(new String[] { "被改变的参数" });
		System.out.println("执行目标方法之后，模拟结束事务...");
		return rvt + " 新增的内容";
	}
}
