package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.exceptions.*;
import com.revature.models.ShopItem;
import com.revature.services.CustomerService;

public class PositiveNumberTest {
	
	private static CustomerService cs;
	
	// Used to set up the test
	@BeforeAll
	public static void setUp() {
		cs = new CustomerService();
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
	public void MakeNegativeOffer() {
		ShopItem si = new ShopItem();
		assertThrows(MakeNegativeOfferException.class, () -> cs.makeOffer(-1, si, 1));
		System.out.println("Divide by zero exception was thrown when dividing 7 by 0");
	}
}