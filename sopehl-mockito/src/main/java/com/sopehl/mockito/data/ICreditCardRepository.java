package com.sopehl.mockito.data;

import com.sopehl.mockito.model.CreditCard;

public interface ICreditCardRepository {

	CreditCard findCreditCardByNumber(String number);
	
}
