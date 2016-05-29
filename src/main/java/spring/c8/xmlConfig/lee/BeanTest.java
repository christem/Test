package spring.c8.xmlConfig.lee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.c8.xmlConfig.crazyit.app.service.Person;

public class BeanTest {
	public static void main(String[] args) {
		// ����Spring����
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/spring/c8/xmlConfig/bean.xml");
		Person p = ctx.getBean("chinese", Person.class);
		System.out.println(p.sayHello("����"));
		p.eat("����");
	}
}