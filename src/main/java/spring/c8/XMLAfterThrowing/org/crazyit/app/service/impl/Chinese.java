package spring.c8.XMLAfterThrowing.org.crazyit.app.service.impl;

import java.io.FileInputStream;

import spring.c8.XMLAfterThrowing.org.crazyit.app.service.Person;

public class Chinese implements Person {
	// 实现Person接口的sayHello()方法
	public String sayHello(String name) {
		// 该方法体内虽然抛出了异常，但该方法
		// 自己处理了该异常，所以AOP不会对该异常进行处理
		try {
			System.out.println("sayHello方法开始被执行...");
			new FileInputStream("a.txt");
		} catch (Exception ex) {
			System.out.println("目标类的异常处理" + ex.getMessage());
		}
		// 返回简单的字符串
		return name + " Hello , Spring AOP";
	}

	// 定义一个divide()方法
	public void divide() {
		int a = 5 / 0;
		System.out.println("divide执行完成！");
	}
}