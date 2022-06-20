package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.exceptions.*;

public class CalculatorTest {
	
	private static Calculator sut;
	
	// Used to set up the test
	@BeforeAll
	public static void setUp() {
		sut = new Calculator();
	}
	
	@AfterAll
	public static void tearDown() {
		System.out.println("Done!");
	}
	
	@BeforeEach
	public void before() {
		System.out.println("Running test...");
	}
	
	@Test
	public void addOneAndTwo() {
		int expected = 3;
		int actual = sut.add(1, 2);
		
		assertEquals(expected, actual);
		System.out.println("Added 1 and 2 successfully.");
	}
	
	@Test
	public void addEightAndFive() {
		assertThrows(Number13Exception.class, () -> sut.add(8, 5));
		System.out.println("Number 13 excecption was thrown when adding 8 and 5.");
//		sut.add(8, 5);
	}
	
	@Test
	public void addZeroAndThirteen() {
		assertThrows(Number13Exception.class, () -> sut.add(0, 13));
		System.out.println("Number 13 exception was thrown when adding 0 and 13.");
	}
	
	@Test
	public void divideSevenAndZero() {
		assertThrows(DivideBy0Exception.class, () -> sut.divide(7, 0));
		System.out.println("Divide by zero exception was thrown when dividing 7 by 0");
//		sut.divide(7, 0);
	}
	
	@Test
	public void sumArray() {
		int[] myArray = {54,12,43,34,102};
		int result = sut.sumOfAnArray(myArray);
		if(sut.sumOfAnArray(myArray) == 245) {
			System.out.println("sumOfAnArray is behaving correctly");
		}
		System.out.println("The elements of the array add up to " + result);
	}
}