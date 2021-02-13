package com.sopehl.data;

import com.sopehl.entity.BookEntity;

public interface BookDBAccessor {

	Boolean save(BookEntity book);
	
	BookEntity getBookByHeader(String header);
	
}
