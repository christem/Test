package spring.c8.BeanPostProcessor.org.crazyit.app.service.impl;

import spring.c8.BeanPostProcessor.org.crazyit.app.service.Axe;

public class SteelAxe implements Axe {
	public SteelAxe() {
		System.out.println("Springʵ��������bean��SteelAxeʵ��...");
	}

	public String chop() {
		return "�ָ��������";
	}
}