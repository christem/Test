package spring.c8.xmlConfig.crazyit.app.advice;

import org.springframework.stereotype.Component;

@Component
public class SecondAdviceTest {
	// 定义Before增强处理
	public void authority(String aa) {
		System.out.println("目标方法的参数为：" + aa);
		System.out.println("①号Before增强：模拟执行权限检查");
	}
}
