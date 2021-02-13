package com.sopehl.mockito.service;

import java.util.List;

import com.sopehl.mockito.model.CreditCard;

public interface ICreditCardService {
	
	CreditCard getCreditCardByNumber(String number);
	
	List<CreditCard> listCreditCardByBank();

}
