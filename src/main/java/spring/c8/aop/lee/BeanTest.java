package spring.c8.aop.lee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.c8.aop.org.crazyit.app.service.Person;

public class BeanTest {
	public static void main(String[] args) {
		// ����Spring����
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/spring/c8/aop/bean.xml");
		Person p = ctx.getBean("chinese", Person.class);
		System.out.println(p.sayHello("����"));

		System.out.println();
		p.eat("����");
		System.out.println();
		p.divide();
	}
}