package com.sopehl.entity;

import java.util.Date;

public class BookEntity {

	private String header;

	private String authorName;

	private Date printDate;

	private String IsbnNumber;
	
	private String userIdentity;

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
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

	public String getUserIdentity() {
		return userIdentity;
	}

	public void setUserIdentity(String userIdentity) {
		this.userIdentity = userIdentity;
	}
	
}
