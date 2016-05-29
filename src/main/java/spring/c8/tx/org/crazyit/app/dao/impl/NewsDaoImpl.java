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
		// 两次插入的数据违反唯一键约束
		// jt.update("insert into news_inf" + " values(null , ? , ?)", title,
		// content);
		// 如果增加事务控制，我们发现第一条记录也插不进去。
		// 如果没有事务控制，则第一条记录可以被插入
	}
}