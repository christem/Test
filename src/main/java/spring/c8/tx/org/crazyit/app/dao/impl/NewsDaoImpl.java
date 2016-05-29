package spring.c8.tx.org.crazyit.app.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import spring.c8.tx.org.crazyit.app.dao.NewsDao;

public class NewsDaoImpl implements NewsDao {
	private DataSource ds;

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	public void insert(String title, String content) {
		JdbcTemplate jt = new JdbcTemplate(ds);
		jt.update("insert into news_inf" + " values(null , ? , ?)", title,
				content);
		// ���β��������Υ��Ψһ��Լ��
		// jt.update("insert into news_inf" + " values(null , ? , ?)", title,
		// content);
		// �������������ƣ����Ƿ��ֵ�һ����¼Ҳ�岻��ȥ��
		// ���û��������ƣ����һ����¼���Ա�����
	}
}