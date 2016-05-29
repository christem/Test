package spring.c8.BeanPostProcessor.org.crazyit.app.service.impl;

import spring.c8.BeanPostProcessor.org.crazyit.app.service.Axe;

public class SteelAxe implements Axe {
	public SteelAxe() {
		System.out.println("Spring实例化依赖bean：SteelAxe实例...");
	}

	public String chop() {
		return "钢斧砍柴真快";
	}
}