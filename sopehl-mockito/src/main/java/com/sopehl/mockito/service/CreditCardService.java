package com.sopehl.mockito.service;

import java.util.List;

import com.sopehl.mockito.data.ICreditCardRepository;
import com.sopehl.mockito.model.CreditCard;

public class CreditCardService implements ICreditCardService {
	
	private ICreditCardRepository creditCardRepository;
	
	public CreditCardService(ICreditCardRepository creditCardRepository) {
		this.creditCardRepository = creditCardRepository;
	}

	@Override
	public CreditCard getCreditCardByNumber(String number) {
		if(number == null || number.length() != 16) {
			throw new RuntimeException("Invalid credit card: " + number);
		}
		return creditCardRepository.findCreditCardByNumber(number);
	}

	@Override
	public List<CreditCard> listCreditCardByBank() {
		// TODO Auto-generated method stub
		return null;
	}

}
