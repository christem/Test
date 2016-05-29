package spring.c8.JoinPoint.lee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.c8.JoinPoint.org.crazyit.app.service.Person;

public class BeanTest {
	public static void main(String[] args) {
		// ����Spring����
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/spring/c8/JoinPoint/bean.xml");
		Person p = (Person) ctx.getBean("chinese");
		System.out.println(p.sayHello("����"));
		p.eat("����");
	}
}