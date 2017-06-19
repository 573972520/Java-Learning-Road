package com.rupeng.test;

import java.sql.Date;

public class ArticleCommentInfo {
	private int id;
	private int articleId;
	private String content;
	private Date postDataTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPostDataTime() {
		return postDataTime;
	}
	public void setPostDataTime(Date postData) {
		this.postDataTime = postData;
	}

	
}
