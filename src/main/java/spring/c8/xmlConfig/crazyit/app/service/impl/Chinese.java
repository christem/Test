package spring.c8.xmlConfig.crazyit.app.service.impl;

import org.springframework.stereotype.Component;

import spring.c8.xmlConfig.crazyit.app.service.Person;

@Component
public class Chinese implements Person {
	// ʵ��Person�ӿڵ�sayHello()����
	public String sayHello(String name) {
		System.out.println("sayHello����������...");
		// ���ؼ򵥵��ַ���
		return name + " Hello , Spring AOP";
	}

	// ����һ��eat()����
	public void eat(String food) {
		System.out.println("�����ڳ�:" + food);
	}
}