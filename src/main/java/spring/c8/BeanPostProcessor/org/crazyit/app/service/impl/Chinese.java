package spring.c8.BeanPostProcessor.org.crazyit.app.service.impl;

import org.springframework.beans.factory.InitializingBean;

import spring.c8.BeanPostProcessor.org.crazyit.app.service.Axe;
import spring.c8.BeanPostProcessor.org.crazyit.app.service.Person;

public class Chinese implements Person, InitializingBean {
	private Axe axe;
	private String name;

	public Chinese() {
		System.out.println("Springʵ��������bean��Chineseʵ��...");
	}

	public void setAxe(Axe axe) {
		this.axe = axe;
	}

	public void setName(String name) {
		System.out.println("Springִ��������ϵע��...");
		this.name = name;
	}

	public void useAxe() {
		System.out.println(name + axe.chop());
	}

	// �����������������ڷ���
	public void init() {
		System.out.println("����ִ�г�ʼ������   init...");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("����ִ�г�ʼ������  afterPropertiesSet...");
	}
}