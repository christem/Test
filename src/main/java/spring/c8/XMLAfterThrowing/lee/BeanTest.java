package spring.c8.XMLAfterThrowing.lee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.c8.XMLAfterThrowing.org.crazyit.app.service.Person;

public class BeanTest {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext(
				"/spring/c8/XMLAfterThrowing/bean.xml");
		Person p = ctx.getBean("chinese", Person.class);
		System.out.println(p.sayHello("уехЩ"));
		p.divide();
	}
}