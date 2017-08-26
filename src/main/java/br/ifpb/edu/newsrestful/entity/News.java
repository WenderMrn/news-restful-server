package br.ifpb.edu.newsrestful.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@XmlRootElement
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String author;

	@Column
	private String title;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(columnDefinition = "text")
	private String content;

	public News() {
		super();
		// TODO Auto-generated constructor stub
	}

	public News(String title, String content, Date date, String author) {
		super();
		this.author = author;
		this.title = title;
		this.date = date;
		this.content = content;
	}

	public News(String title, String content, String author) {
		super();
		this.author = author;
		this.title = title;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", author=" + author + ", title=" + title + ", date=" + date + ", content=" + content
				+ "]";
	}

}
