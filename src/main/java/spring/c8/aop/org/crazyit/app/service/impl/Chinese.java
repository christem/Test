package spring.c8.aop.org.crazyit.app.service.impl;

import java.io.FileInputStream;

import org.springframework.stereotype.Component;

import spring.c8.aop.org.crazyit.app.service.Person;

@Component
public class Chinese implements Person {
	// ����һ��eat()����
	public void eat(String food) {
		System.out.println("�����ڳ�:" + food);
	}

	// ʵ��Person�ӿڵ�sayHello()����
	public String sayHello(String name) {
		// �÷���������Ȼ�׳����쳣�����÷���
		// �Լ������˸��쳣������AOP����Ը��쳣���д���
		try {
			System.out.println("sayHello������ʼ��ִ��...");
			new FileInputStream("a.txt");
		} catch (Exception ex) {
			System.out.println("Ŀ������쳣����" + ex.getMessage());
		}
		// ���ؼ򵥵��ַ���
		return name + " Hello , Spring AOP";
	}

	// ����һ��divide()����
	public void divide() {
		int a = 5 / 0;
		System.out.println("divideִ����ɣ�");
	}
}