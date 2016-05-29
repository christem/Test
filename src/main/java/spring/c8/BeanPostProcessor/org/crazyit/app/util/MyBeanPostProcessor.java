package spring.c8.BeanPostProcessor.org.crazyit.app.util;

import org.springframework.beans.factory.config.BeanPostProcessor;

import spring.c8.BeanPostProcessor.org.crazyit.app.service.impl.Chinese;

public class MyBeanPostProcessor implements BeanPostProcessor {
	/**
	 * �������е�Beanʵ�����к���
	 * 
	 * @param bean
	 *            ��Ҫ���к����ԭBeanʵ��
	 * @param beanName
	 *            ��Ҫ���к����Beanʵ��������
	 * @return ���غ�����ɺ��Bean
	 */
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		System.out.println("Bean�������ڳ�ʼ��֮ǰ��" + beanName + "������ǿ����...");
		// ���صĴ�����Beanʵ����
		// ��Beanʵ�����������е�ʱʵ��ʹ�õ�Beanʵ��
		// ��Beanʵ����������ԭBean��Ȼ��ͬ
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) {
		System.out.println("Bean�������ڳ�ʼ��֮���" + beanName + "������ǿ����...");
		// �����Bean��Chinese���ʵ��
		if (bean instanceof Chinese) {
			// �޸���name����ֵ
			Chinese c = (Chinese) bean;
			c.setName("Struts 2Ȩ��ָ��");
		}
		return bean;
	}
}
