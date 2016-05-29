package spring.c8.xmlConfig.crazyit.app.service.impl;

import org.springframework.stereotype.Component;

import spring.c8.xmlConfig.crazyit.app.service.Person;

@Component
public class Chinese implements Person {
	// 实现Person接口的sayHello()方法
	public String sayHello(String name) {
		System.out.println("sayHello方法被调用...");
		// 返回简单的字符串
		return name + " Hello , Spring AOP";
	}

	// 定义一个eat()方法
	public void eat(String food) {
		System.out.println("我正在吃:" + food);
	}
}