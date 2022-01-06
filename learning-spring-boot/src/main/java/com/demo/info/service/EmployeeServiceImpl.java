package com.demo.info.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.demo.info.model.Employee;
import com.demo.info.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static List<Employee> empList = new ArrayList<Employee>();
	@Autowired
	private EmployeeRepository eRepository;
	
	/* static {
		Employee employee = new Employee();
		employee.setName("Hariprasanth");
		employee.setAge(32);
		employee.setDepartment("IT");
		employee.setEmail("Hariprasanth@gmail.com");
		employee.setLocation("USA");
		empList.add(employee);
		
		employee = new Employee();
		employee.setName("appa");
		employee.setAge(72);
		employee.setDepartment("VAO");
		employee.setEmail("appa@gmail.com");
		employee.setLocation("USA");
		empList.add(employee);
		
		
	}*/

	@Override
	public List<Employee> getEmployees() {
		
		return this.eRepository.findAll();
	}

	@Override
	public Employee saveEmpl(Employee employee) {
		Employee save = this.eRepository.save(employee);
		if (save != null) {
			
		}
		return this.eRepository.save(employee);
	}

	@Override
	public Employee getSingleEmployee(long id) {
		Optional<Employee> findById = this.eRepository.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		throw new RuntimeException("Employee is not found for the id " + id);
	}

	@Override
	public void deleteEmployee(Long id) {
		System.out.println("Delete the id : " + id);
		this.eRepository.deleteById(id);
	}
	
	@Override
	public Employee updateExsitingEmplRecord(Employee employee) {
		return this.eRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployeesByName(String name) {
		return this.eRepository.findByName(name);
	}

	@Override
	public List<Employee> getEmployeesByNameAndLocation(String name, String location) {

		return this.eRepository.findBynameAndLocation(name, location);
	}

	@Override
	public List<Employee> getEmployeesByKeywordContains(String keyword) {
		Sort sort = Sort.by(Sort.Direction.ASC, "id");
		return this.eRepository.findBynameContaining(keyword,sort);
	}
	
	
	////  page navigation
	@Override
	public List<Employee> getEmployeesPages(int pageNumber, int pageSize) {
		Pageable pages = PageRequest.of(pageNumber, pageSize, Direction.DESC,"id");
		
		return this.eRepository.findAll(pages).getContent();
	}

	@Override
	public List<Employee> getEmployeesByNameORLocationCheck(String name, String location) {
		return this.eRepository.getEmployeesByNameORLocation(name, location);
	}

	@Override
	public Integer deleteByEmployeeame(String name) {
		
		return this.eRepository.deleteEmployeeByName(name);
	}
	
	//// Sorting JPA 
	
//	@Override
//	public List<Employee> getEmployeesByKeywordSorting(String name) {
//		//Sort sort = Sort.by(keyword).descending();
//		Sort sort = Sort.by(Sort.Direction.DESC,"id"); 
//		return this.eRepository.findBynameContainingSort(name,sort);
//	}
	

}
