package spring.c8.XMLAfterThrowing.org.crazyit.app.service.impl;

import java.io.FileInputStream;

import spring.c8.XMLAfterThrowing.org.crazyit.app.service.Person;

public class Chinese implements Person {
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