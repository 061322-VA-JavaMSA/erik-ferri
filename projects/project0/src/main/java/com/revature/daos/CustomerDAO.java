package com.revature.daos;

import java.util.List;

import com.revature.models.Customer;

public interface CustomerDAO {
	Customer createCustomer(Customer cu);
	Customer retrieveCustomerById(int id);
	List<Customer> retrieveCustomers();
	Customer retrieveCustomerByUsername(String username);
	boolean updateCustomer(Customer cu);
	boolean deleteCustomerById(int id);
}