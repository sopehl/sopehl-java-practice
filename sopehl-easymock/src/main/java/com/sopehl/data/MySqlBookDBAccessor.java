package com.sopehl.data;

import com.sopehl.entity.BookEntity;

public class MySqlBookDBAccessor implements BookDBAccessor {

	@Override
	public Boolean save(BookEntity book) {
		// real save to real database
		return true;
	}

	@Override
	public BookEntity getBookByHeader(String header) {
		// get data from real database
		return new BookEntity();
	}

}
