package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDAO {
	Employee createEmployee(Employee em);
	Employee retrieveEmployeeById(int id);
	List<Employee> retrieveEmployees();
	Employee retrieveEmployeeByUsername(String username);
	boolean updateEmployee(Employee em);
	boolean deleteEmployeeById(int id);
}