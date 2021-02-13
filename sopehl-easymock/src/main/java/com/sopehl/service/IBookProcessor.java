package com.sopehl.service;

import com.sopehl.model.BookInformation;

public interface IBookProcessor {

	Boolean save(BookInformation bookInformation);
	
	BookInformation getBookByHeader(String header);
	
	Boolean assignBook(String header, String userIdentity);
	
}
