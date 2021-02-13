package com.sopehl.service;

import com.sopehl.data.BookDBAccessor;
import com.sopehl.entity.BookEntity;
import com.sopehl.model.BookInformation;

public class BookProcessor implements IBookProcessor{
	
	private BookDBAccessor bookDbAccessor;
	
	public BookProcessor(BookDBAccessor bookDbAccessor) {
		this.bookDbAccessor = bookDbAccessor;
	}

	@Override
	public Boolean save(BookInformation bookInformation) {
		String isbnNumber = bookInformation.getIsbnNumber();
		if(isbnNumber == null || isbnNumber.length() != 13) {
			return false;
		}
		
		BookEntity book = new BookEntity();
		book.setAuthorName(bookInformation.getAuthor().getName());
		book.setHeader(bookInformation.getHeader());
		book.setIsbnNumber(bookInformation.getIsbnNumber());
		book.setPrintDate(bookInformation.getPrintDate());
		book.setUserIdentity(bookInformation.getUserIdentityNumber());
		
		return this.bookDbAccessor.save(book);
	}

	@Override
	public BookInformation getBookByHeader(String header) {
		if(header == null || header.equals("")) {
			return null;
		}
		BookEntity bookEntity = bookDbAccessor.getBookByHeader(header);
		BookInformation bookInformation = new BookInformation(bookEntity);
		return bookInformation;
	}

	@Override
	public Boolean assignBook(String header, String userIdentity) {
		BookInformation bookInformation = this.getBookByHeader(header);
		if(userIdentity == null) {
			return false;
		}
		bookInformation.setUserIdentityNumber(userIdentity);
		return this.save(bookInformation);
	}
	
}
