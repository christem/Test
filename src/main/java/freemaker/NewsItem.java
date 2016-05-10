package freemaker;

import java.util.Date;

public class NewsItem {
    private String title;

    private Date addtime;

    private int showContent;

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public Date getAddtime() {
	return addtime;
    }

    public void setAddtime(Date addtime) {
	this.addtime = addtime;
    }

    public int getShowContent() {
	return showContent;
    }

    public void setShowContent(int showContent) {
	this.showContent = showContent;
    }

}
