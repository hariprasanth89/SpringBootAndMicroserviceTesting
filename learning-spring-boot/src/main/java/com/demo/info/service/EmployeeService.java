package com.demo.info.service;

import java.util.List;

import com.demo.info.model.Employee;

public interface EmployeeService {

	 List<Employee> getEmployees();
	 
	 Employee saveEmpl(Employee employee);
	 
	 Employee getSingleEmployee(long id);
	 
	 void deleteEmployee(Long id);
	 
	 Employee updateExsitingEmplRecord(Employee employee);
	 
	 List<Employee> getEmployeesByName(String name);
	 
	 List<Employee> getEmployeesByNameAndLocation(String name, String location);
	 
	 List<Employee> getEmployeesByKeywordContains(String keyword);
	 
	 
	 /// Pages 
	 List<Employee> getEmployeesPages(int pageNumber, int pageSize);
	 
	 
	 // Sort
	// List<Employee> getEmployeesByKeywordSorting(String name);
	 
	 
	List<Employee> getEmployeesByNameORLocationCheck(String name, String location);
	
	
	Integer deleteByEmployeeame(String name);
	 
}
