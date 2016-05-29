package spring.c8.tx.lee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.c8.tx.org.crazyit.app.dao.NewsDao;

public class SpringTest {
	public static void main(String[] args) {
		// ����Spring����
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/spring/c8/tx/bean.xml");
		// ��ȡ�������Bean
		NewsDao dao = (NewsDao) ctx.getBean("newsDao", NewsDao.class);
		// ִ�в������
		dao.insert("���Java", "������Java EE��ҵӦ��ʵս");
	}
}
