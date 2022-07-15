package com.revature;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hibernate.PropertyValueException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.exceptions.*;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;

import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;

public class ERSTest {
	
	private static AuthService as;
	private static ReimbursementService rs;
	private static UserService us;
	
	// Used to set up the test
	@BeforeAll
	public static void setUp() {
		as = new AuthService();
		rs = new ReimbursementService();
		us = new UserService();
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
	public void loginUserNotFound() {
		assertThrows(NoResultException.class, () -> as.login("notauser","notapassword"));
		System.out.println("NoResultException was thrown when trying to login as a user that doesn't exist");
	}
	@Test
	public void reimbursementNotCreated() {
		Reimbursement re = new Reimbursement();
		assertThrows(ReimbursementNotCreatedException.class, () -> rs.createReimbursement(re));
		System.out.println("ReimbursementNotCreatedException was thrown when trying to create an invalid Reimbursement");
	}
	@Test
	public void getReimbursementByIdNotFound() {
		assertThrows(ReimbursementNotFoundException.class, () -> rs.getReimbursementById(9999999));
		System.out.println("ReimbursementNotFoundException was thrown when trying to get a Reimbursement that doesn't exist");
	}
	@Test
	public void updateReimbursementNotFound() {
		assertThrows(PersistenceException.class, () -> rs.updateReimbursement(9999999,"doesntexist",9999999));
		System.out.println("PersistenceException was thrown when trying to update a Reimbursement that doesn't exist");
	}
	@Test
	public void UserNotCreated() {
		User u = new User();
		assertThrows(PropertyValueException.class, () -> us.createUser(u));
		System.out.println("UserNotCreatedException was thrown when trying to create an invalid User");
	}
	@Test
	public void getUserByIdNotFound() {
		assertThrows(UserNotFoundException.class, () -> us.getUserById(9999999));
		System.out.println("UserNotFoundException was thrown when trying to get a User that doesn't exist");
	}
}