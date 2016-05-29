package spring.c8.tx.lee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.c8.tx.org.crazyit.app.dao.NewsDao;

public class SpringTest {
	public static void main(String[] args) {
		// 创建Spring容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/spring/c8/tx/bean.xml");
		// 获取事务代理Bean
		NewsDao dao = (NewsDao) ctx.getBean("newsDao", NewsDao.class);
		// 执行插入操作
		dao.insert("疯狂Java", "轻量级Java EE企业应用实战");
	}
}
