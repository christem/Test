package spring.c8.ReusePointcut.org.crazyit.app.service.impl;

import org.springframework.stereotype.Component;

import spring.c8.ReusePointcut.org.crazyit.app.service.Person;

@Component
public class Chinese implements Person {
	// ʵ��Person�ӿڵ�sayHello()����
	public String sayHello(String name) {
		// ���ؼ򵥵��ַ���
		return name + " Hello , Spring AOP";
	}
}