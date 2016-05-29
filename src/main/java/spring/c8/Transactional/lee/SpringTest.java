package spring.c8.Transactional.lee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.c8.Transactional.org.crazyit.app.dao.NewsDao;

public class SpringTest {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext(
				"/spring/c8/Transactional/bean.xml");
		// ��ȡ�������Bean
		NewsDao dao = (NewsDao) ctx.getBean("newsDao", NewsDao.class);
		// ִ�в������
		dao.insert("���Java", "������Java EE��ҵӦ��ʵս");
	}
}
