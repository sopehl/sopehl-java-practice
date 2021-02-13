package com.sopehl.mockito.data;

import com.sopehl.mockito.model.CreditCard;

public class CreditCardRepository implements ICreditCardRepository{

	@Override
	public CreditCard findCreditCardByNumber(String number) {
		CreditCard creditCard = new CreditCard();
		creditCard.setBank("YKB");
		creditCard.setCardNumber("5377148897389624");
		creditCard.setCvv("669");
		creditCard.setExpireDate("0422");
		return creditCard;
	}

}
