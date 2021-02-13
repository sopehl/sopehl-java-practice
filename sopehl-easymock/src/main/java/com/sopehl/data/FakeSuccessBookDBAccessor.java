package com.sopehl.data;

import java.util.Date;

import com.sopehl.entity.BookEntity;

public class FakeSuccessBookDBAccessor implements BookDBAccessor {

	@Override
	public Boolean save(BookEntity book) {
		return true;
	}

	@Override
	public BookEntity getBookByHeader(String header) {
		BookEntity book = new BookEntity();
		book.setAuthorName("Down Brown");
		book.setHeader("Crime Victim");
		book.setPrintDate(new Date());
		book.setIsbnNumber("9780495599296");
		
		return book;
	}

}
