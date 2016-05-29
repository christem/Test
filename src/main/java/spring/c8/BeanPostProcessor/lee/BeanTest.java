package spring.c8.BeanPostProcessor.lee;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import spring.c8.BeanPostProcessor.org.crazyit.app.service.Person;
import spring.c8.BeanPostProcessor.org.crazyit.app.util.MyBeanPostProcessor;

/**
 * Description: <br/>
 * ��վ: <a href="http://www.crazyit.org">���Java����</a> <br/>
 * Copyright (C), 2001-2012, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class BeanTest {
	public static void main(String[] args) throws Exception {
		// CLASSPATH·���µ�bean.xml�ļ�����Resource����
		ClassPathResource isr = new ClassPathResource(
				"/spring/c8/BeanPostProcessor/bean.xml");
		// ��Resource������Ϊ����������BeanFactory��ʵ��
		XmlBeanFactory factory = new XmlBeanFactory(isr);
		// ��ȡBean������ʵ��
		MyBeanPostProcessor prr = factory.getBean("beanPostProcessor",
				MyBeanPostProcessor.class);
		// ע��BeanPostProcessorʵ��
		factory.addBeanPostProcessor(prr);
		System.out.println("�����Ѿ�ʵ����BeanFactory...");
		Person p = factory.getBean("chinese", Person.class);
		System.out.println("�������Ѿ������chinese bean��ʵ����...");
		p.useAxe();
		// ApplicationContext ctx = new
		// ClassPathXmlApplicationContext("bean.xml");
		// Person p = (Person)ctx.getBean("chinese");
		// p.useAxe();
	}
}