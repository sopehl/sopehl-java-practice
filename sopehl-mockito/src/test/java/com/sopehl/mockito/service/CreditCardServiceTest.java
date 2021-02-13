package com.sopehl.mockito.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.sopehl.mockito.data.ICreditCardRepository;
import com.sopehl.mockito.model.CreditCard;

public class CreditCardServiceTest {

	private static final String CARD_NUMBER = "5123529623726444";

	private CreditCard creditCard;
	
	@Before
	public void setup() {
		creditCard = new CreditCard();
		creditCard.setBank("YKB");
		creditCard.setCardNumber(CARD_NUMBER);
		creditCard.setCvv("854");
		creditCard.setExpireDate("1221");
	}
	
	@Test
	public void getCreditCardByNumber_success() {
		ICreditCardRepository creditCardRepository = mock(ICreditCardRepository.class);
		CreditCardService cardService = new CreditCardService(creditCardRepository);
		when(creditCardRepository.findCreditCardByNumber(CARD_NUMBER)).thenReturn(creditCard);
		
		CreditCard creditCard = cardService.getCreditCardByNumber(CARD_NUMBER);
		
		assertNotNull(creditCard);
	}
	
	@Test(expected = RuntimeException.class)
	public void getCreditCardByNumber_inValidCardNumber() {
		ICreditCardRepository creditCardRepository = mock(ICreditCardRepository.class);
		CreditCardService cardService = new CreditCardService(creditCardRepository);
		
		cardService.getCreditCardByNumber(CARD_NUMBER + 123);
		cardService.getCreditCardByNumber(null);
	}

}
