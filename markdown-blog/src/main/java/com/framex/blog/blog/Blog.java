package com.framex.blog.blog;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Blog implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator="idGenerator")
	private String id;
	
	@Column(nullable = true)
	private String title;
	
	@Column(nullable = true)
	private String author;
	
	@Column(nullable = true)
	private Date createTime;
	
	@Column(nullable = true)
	private Date modifyTime;
	
	@Column(nullable = true)
	private String markdownContent;
	
	@Column(nullable = true)
	private String htmlContent;

	protected Blog() {
	}

	public Blog(String id, String title, String author, Date createTime, Date modifyTime, String markdownContent,
			String htmlContent) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.markdownContent = markdownContent;
		this.htmlContent = htmlContent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getMarkdownContent() {
		return markdownContent;
	}

	public void setMarkdownContent(String markdownContent) {
		this.markdownContent = markdownContent;
	}

	public String getHtmlContent() {
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", author=" + author + ", createTime=" + createTime
				+ ", modifyTime=" + modifyTime + ", markdownContent=" + markdownContent + ", htmlContent=" + htmlContent
				+ "]";
	}
	
	
	
	
	

}
