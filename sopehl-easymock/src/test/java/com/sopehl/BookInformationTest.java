package com.sopehl;

import com.sopehl.data.BookDBAccessor;
import com.sopehl.data.FakeSuccessBookDBAccessor;
import com.sopehl.entity.BookEntity;
import com.sopehl.model.Author;
import com.sopehl.model.BookInformation;
import com.sopehl.service.BookProcessor;
import org.easymock.EasyMock;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class BookInformationTest {
	
	private static final String CRIME_VICTIM = "Crime Victim";

	@Test
	public void saveBookInformation_withCustomFakeClasses_success() {
		BookInformation bookInformation = new BookInformation();
		bookInformation.setAuthor(new Author("Down Brown"));
		bookInformation.setHeader(CRIME_VICTIM);
		bookInformation.setPrintDate(new Date());
		bookInformation.setIsbnNumber("9780495599296");
		
		// do not use production db accessor, use fake classes's object.
		// BookProcessor bookProcessor = new BookProcessor(new MySqlBookDBAccessor());
		BookProcessor bookProcessor = new BookProcessor(new FakeSuccessBookDBAccessor());
		Boolean isSaved = bookProcessor.save(bookInformation);
		
		assertTrue(isSaved);
	}
	
	@Test
	public void saveBookInformation_withCustomFakeClasses_inValidIsbn() {
		BookInformation bookInformation = new BookInformation();
		bookInformation.setAuthor(new Author("Down Brown"));
		bookInformation.setHeader(CRIME_VICTIM);
		bookInformation.setPrintDate(new Date());
		bookInformation.setIsbnNumber("9780495599296111");
		
		// do not use production db accessor, use fake classes's object.
		// BookProcessor bookProcessor = new BookProcessor(new MySqlBookDBAccessor());
		BookProcessor bookProcessor_withInvalidIsbn = new BookProcessor(new FakeSuccessBookDBAccessor());
		Boolean expectedFalse_withInvalidIsbn = bookProcessor_withInvalidIsbn.save(bookInformation);
		assertFalse(expectedFalse_withInvalidIsbn);
		
		BookProcessor bookProcessor_withNullIsbn = new BookProcessor(new FakeSuccessBookDBAccessor());
		bookInformation.setIsbnNumber(null);
		Boolean expectedFalse_withNullIsbn = bookProcessor_withNullIsbn.save(bookInformation);
		
		assertFalse(expectedFalse_withNullIsbn);
	}
	
	@Test 
	public void assignBookToUser_withCustomFakeClasses_success() {
		BookProcessor bookProcessor = new BookProcessor(new FakeSuccessBookDBAccessor());
		
		Boolean successAssignment = bookProcessor.assignBook(CRIME_VICTIM, "Okan");
		assertTrue(successAssignment);
	}
	
	@Test 
	public void assignBookToUser_withCustomFakeClasses_fail() {
		BookProcessor bookProcessor = new BookProcessor(new FakeSuccessBookDBAccessor());
		
		Boolean successAssignment = bookProcessor.assignBook(CRIME_VICTIM, null);
		assertFalse(successAssignment);
	}
	
	@Test 
	public void assignBookToUser_withCustomMockClasses_success() {
		BookDBAccessor mockAccessor = EasyMock.createMock(BookDBAccessor.class);
		BookProcessor bookProcessor = new BookProcessor(mockAccessor);
		
		BookEntity book = new BookEntity();
		book.setAuthorName("Down Brown");
		book.setHeader(CRIME_VICTIM);
		book.setIsbnNumber("9780495599296");
		book.setPrintDate(new Date());
		
		EasyMock.expect(mockAccessor.getBookByHeader(CRIME_VICTIM)).andReturn(book);
		
		EasyMock.expect(mockAccessor.save(EasyMock.anyObject(BookEntity.class))).andReturn(true);
		
		EasyMock.replay(mockAccessor);
		
		Boolean successAssignment = bookProcessor.assignBook(CRIME_VICTIM, "Okan");
		assertTrue(successAssignment);
	}
	
	@Test
	public void getHeaderTest_withFail() {
		BookDBAccessor mockAccessor = EasyMock.createMock(BookDBAccessor.class);
		BookProcessor bookProcessor = new BookProcessor(mockAccessor);
		
		BookInformation bookInformation_withNullParam = bookProcessor.getBookByHeader(null);
		assertNull(bookInformation_withNullParam);
		
		BookInformation bookInformation_withEmptyParam = bookProcessor.getBookByHeader("");
		assertNull(bookInformation_withEmptyParam);
	}
	
	
}
