package com.demo.info.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.info.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByName(String name);
	
	//Select * from tablename where name = "hari" and location="india";
	List<Employee> findBynameAndLocation(String name, String location);
	
	List<Employee> findBynameContaining(String keyword, Sort sort);
	
	
	//List<Employee> findBynameLike(String keyword);
	
	
	// Sort
	//List<Employee> findBynameContainingSort(String name, Sort sort);
	
	//@Query(value = "SELECT ...", nativeQuery = true)

	 @Query(value = "select * FROM tbl_employee WHERE name = :name OR location = :location", nativeQuery = true)
	 List<Employee> getEmployeesByNameORLocation(String name, String location);
	 
	 @Transactional
	 @Modifying
	 @Query(value = "DELETE FROM tbl_employee where name =:name", nativeQuery = true)
	 Integer deleteEmployeeByName(String name);
	 
	 
	 
}
