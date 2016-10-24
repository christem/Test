package hibernate.c5.HibernateAnnoDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class NewsManager {

	public static void main(String[] args) throws Exception {
		// 实例化Configuration，下面方法默认加载hibernate.cfg.xml文件
		Configuration conf = new Configuration()
				.configure("/hibernate/c5/HibernateAnnoDemo/hibernate.cfg.xml");
		// 以Configuration创建SessionFactory
		SessionFactory sf = conf.buildSessionFactory();
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();

		 // 创建消息实例
		 News n = new News();
		 // 设置消息标题和消息内容
		 n.setTitle("疯狂Java联盟成立了");
		 n.setContent("疯狂Java联盟成立了，" + "网站地址http://www.crazyit.org");
		 // 保存消息
		 sess.save(n);
		 
		// 创建消息实例
		 News n2 = new News();
		 // 设置消息标题和消息内容
		 n2.setTitle("疯狂Java联盟成立了");
		 n2.setContent("疯狂Java联盟成立了，" + "网站地址http://www.crazyit.org");
		 // 保存消息
		 sess.save(n2);

//		List<News> list = sess.createQuery("from News where id=1 ")
//				.setMaxResults(1).list();

//		for (News bean : list) {
//			System.out.println(bean.getId() + "    " + bean.getTitle() + "    "
//					+ bean.getContent());
//
//			if (bean.getId() == 9) {
//				bean.setContent("update");
//				sess.update(bean);
//			}
//		}

		// 提交事务
		tx.commit();

		// 关闭Session
		sess.close();
		sf.close();
	}
}
