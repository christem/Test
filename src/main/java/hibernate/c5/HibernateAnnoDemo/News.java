package hibernate.c5.HibernateAnnoDemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// @Entity表示该类能被hibernate持久化
@Table(name = "news")
// 指定Entity对应的数据表名
public class News {
	@Id
	// 指定该列为主键
	@GeneratedValue(strategy = GenerationType.AUTO)
	// auto为自增长
	private Integer id;
	@Column(name = "title")
	private String title;
	@Column(name = "content")
	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
