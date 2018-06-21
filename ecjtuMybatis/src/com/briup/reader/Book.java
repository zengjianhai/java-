package com.briup.reader;

import java.util.Date;

public class Book {
	private Integer id;
	private String bookName;
	private String author;
	private Date publishDate;
	private Double price;
	
	public Book() {}
	public Book(Integer id, String bookName, String author, Date publishDate, Double price) {
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.publishDate = publishDate;
		this.price = price;
	}
	public Book(String bookName, String author, Date publishDate, Double price) {
		this.bookName = bookName;
		this.author = author;
		this.publishDate = publishDate;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", author=" + author + ", publishDate=" + publishDate
				+ ", price=" + price + "]";
	}
}
