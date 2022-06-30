package com.revature.exceptions;

public class MakeNegativeOfferException extends Exception {
	public MakeNegativeOfferException(String e){
//		e = "You can't make a negative offer";
		super(e);
	}
}