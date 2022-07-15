package com.revature.services;

import java.util.List;

import com.revature.daos.UserDAO;
import com.revature.daos.UserHibernate;
import com.revature.exceptions.ReimbursementNotFoundException;
import com.revature.exceptions.UserNotCreatedException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Role;
import com.revature.models.User;

public class UserService {

	private UserDAO ud = new UserHibernate();
	
	public User createUser(User u) throws UserNotCreatedException {
		// by default, created account will be basic Users
//		u.setRole(Role.BASIC_USER);
		
		User createdUser = ud.insertUser(u);
		if(createdUser.getId() == -1) {
			throw new UserNotCreatedException();
		}
		return createdUser;
	}
	
	public User getUserById(int id) throws UserNotFoundException {
		User u = ud.getUserById(id);
		if (u == null) {
			throw new UserNotFoundException();
		}
		return u;
	}	
	
	public List<User> getEmployees() {
		List<User> users = ud.getEmployees();
		return users;
	}
	
	public int updateUsername(int id, String username) throws UserNotFoundException {
		int result = ud.updateUsername(id, username);
		if (result == 0) {
			throw new UserNotFoundException();
		}
		return result;
	}

}