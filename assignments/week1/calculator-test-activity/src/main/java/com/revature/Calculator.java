package com.revature;

import com.revature.exceptions.Number13Exception;
import com.revature.exceptions.DivideBy0Exception;

public class Calculator {
	
	public int add(int a, int b) {
		if(a + b == 13) {
			throw new Number13Exception("You added to 13... you will now have bad luck.");
		}
		return a + b;
	}
	
	public int subtract(int a, int b) {
		return a - b;
	}
	
	public int multiply(int a, int b) {
		return a * b;
	}
	
	public int divide(int a, int b) {
		if(b == 0) {
			throw new DivideBy0Exception("You can't divide by zero.");
		}
		return a / b;
	}
	
	public int sumOfAnArray(int[] intArr) {
		return 0;
	}
}