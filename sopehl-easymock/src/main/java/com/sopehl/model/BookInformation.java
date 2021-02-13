package com.sopehl.model;

import java.util.Date;

import com.sopehl.entity.BookEntity;

public class BookInformation {

	private String header;
	
	private Author author;
	
	private Date printDate;
	
	private String IsbnNumber;
	
	private String userIdentityNumber;
	
	public BookInformation() {
		super();
	}
	
	public BookInformation(BookEntity entity) {
		this.header = entity.getHeader();
		this.IsbnNumber = entity.getIsbnNumber();
		this.printDate = entity.getPrintDate();
		this.author = new Author(entity.getAuthorName());
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Date getPrintDate() {
		return printDate;
	}

	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}

	public String getIsbnNumber() {
		return IsbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		IsbnNumber = isbnNumber;
	}

	public String getUserIdentityNumber() {
		return userIdentityNumber;
	}

	public void setUserIdentityNumber(String userIdentityNumber) {
		this.userIdentityNumber = userIdentityNumber;
	}
	
}
