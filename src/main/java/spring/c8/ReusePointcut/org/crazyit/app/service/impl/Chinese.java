package spring.c8.ReusePointcut.org.crazyit.app.service.impl;

import org.springframework.stereotype.Component;

import spring.c8.ReusePointcut.org.crazyit.app.service.Person;

@Component
public class Chinese implements Person {
	// 实现Person接口的sayHello()方法
	public String sayHello(String name) {
		// 返回简单的字符串
		return name + " Hello , Spring AOP";
	}
}