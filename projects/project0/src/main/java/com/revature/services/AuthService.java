package com.revature.services;

//import com.revature.daos.UserDAO;
import com.revature.daos.CustomerDAO;
import com.revature.daos.EmployeeDAO;
//import com.revature.daos.UserPostgres;
import com.revature.daos.CustomerPostgres;
import com.revature.daos.EmployeePostgres;
import com.revature.exceptions.LoginException;
import com.revature.models.User;
import com.revature.models.Customer;
import com.revature.models.Employee;

public class AuthService {

	private CustomerDAO cd = new CustomerPostgres();
	private EmployeeDAO ed = new EmployeePostgres();
	
	public User login(String username, String password) throws LoginException {
		// if username/password passed are null, throws an exception
		if(username == null || password == null) {
			throw new LoginException();
		}
		
		Customer cu = cd.retrieveCustomerByUsername(username);
		Employee em = ed.retrieveEmployeeByUsername(username);
		// if no customer/employee of that name has been retrieved/if pass don't match, throw an exception
		if((cu == null || !cu.getPassword().equals(password)) && (em == null || !em.getPassword().equals(password))){
			throw new LoginException();
		}
//		If it doesn't find the user in the customers table...
		if(cu == null) {
//			retrieve the user from the employees table
			return em;
		} else {
//			Otherwise, retrieve from the customers table
			return cu;	
		}
	}
}