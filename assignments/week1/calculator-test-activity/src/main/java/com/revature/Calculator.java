package com.revature;

import com.revature.exceptions.Number13Exception;

public class Calculator {
	
	public int add(int a, int b) {
		if(a + b == 13) {
			throw new Number13Exception();
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
		return a / b;
	}
	
	public int sumOfAnArray(int[] intArr) {
		return 0;
	}
}