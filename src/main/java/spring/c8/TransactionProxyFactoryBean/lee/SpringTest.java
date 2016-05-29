package spring.c8.TransactionProxyFactoryBean.lee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.c8.TransactionProxyFactoryBean.org.crazyit.app.dao.NewsDao;

public class SpringTest {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext(
				"/spring/c8/TransactionProxyFactoryBean/bean.xml");
		// 获取事务代理Bean
		NewsDao dao = (NewsDao) ctx.getBean("newsDaoTrans", NewsDao.class);
		// 执行插入操作
		dao.insert("疯狂Java", "轻量级Java EE企业应用实战");
	}
}
