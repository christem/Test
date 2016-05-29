package spring.c8.BeanPostProcessor.org.crazyit.app.service.impl;

import org.springframework.beans.factory.InitializingBean;

import spring.c8.BeanPostProcessor.org.crazyit.app.service.Axe;
import spring.c8.BeanPostProcessor.org.crazyit.app.service.Person;

public class Chinese implements Person, InitializingBean {
	private Axe axe;
	private String name;

	public Chinese() {
		System.out.println("Spring实例化主调bean：Chinese实例...");
	}

	public void setAxe(Axe axe) {
		this.axe = axe;
	}

	public void setName(String name) {
		System.out.println("Spring执行依赖关系注入...");
		this.name = name;
	}

	public void useAxe() {
		System.out.println(name + axe.chop());
	}

	// 下面是两个生命周期方法
	public void init() {
		System.out.println("正在执行初始化方法   init...");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("正在执行初始化方法  afterPropertiesSet...");
	}
}