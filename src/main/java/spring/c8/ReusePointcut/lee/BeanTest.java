package spring.c8.ReusePointcut.lee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.c8.ReusePointcut.org.crazyit.app.service.Person;

public class BeanTest {
	public static void main(String[] args) throws Exception {
		// 创建Spring容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/spring/c8/ReusePointcut/bean.xml");
		Person p = ctx.getBean("chinese", Person.class);
		System.out.println(p.sayHello("张三"));
	}
}