package com.demo.info.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.info.model.Employee;
import com.demo.info.service.EmployeeService;
   // java -jar jar name
@RestController   // @@Controller  + @ResponseBody 
//@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	EmployeeService eEmplyService;
	
	@Value("${app.name} : Employee Tracker")
	private String appName;
	
	@Value("${app.version : 1.1}")
	private String appVersion;
	
	@GetMapping("/version")
	public String getAppDetails() {
		
		return appName +  "   "+ appVersion;
	}
	

	//@RequestMapping(value = "/employees", method = RequestMethod.GET)
	//@PostMapping(value = "/employees",produces = MediaType.APPLICATION_JSON_VALUE)
	//@ResponseBody
	@GetMapping("/employees")
	public String getEmployees() {
		System.out.println("My First Spring Tools Project");
		return "Welocme to USA Jobs";
	}
	@GetMapping("/employees/{id}")
	public String getEmployees(@PathVariable("id") long id) {
		return "get the employee detail from single string obkject" + id;
	}
	
	@PostMapping("/employees")
	public String saveEmployee(@RequestBody Employee employee) {
		return "Save emp details" + employee;
	}
	@PutMapping("/employees/{id}")
	public Employee updateEmp(@PathVariable long id, @RequestBody Employee employee) {
		System.out.println("Updating the exsiting data" + id);
		return employee;
	}
	
	
	
	@DeleteMapping("/employees")
	public String deleteTheEmployeeDetails(@RequestParam("id") long id) {
		String deletevariable = "Deleted the Emp record "+id;
		return deletevariable;
	}
	
	
	////////Data base connection
	
	@GetMapping("/employees1")
	public List<Employee> getEmployees1() {
		System.out.println("My First Spring Tools Project get from jpa");
		return this.eEmplyService.getEmployees();
	}
	
	@PostMapping("/employeesDB")
	public Employee saveEmployee1(@Valid @RequestBody Employee employee) {
		return this.eEmplyService.saveEmpl(employee);
	}
	
	@GetMapping("/employeesDB/{id}")
	public Employee getEmplyeeById(@PathVariable long id) {
		System.out.println("get the exsiting data  : "  + id);
		return this.eEmplyService.getSingleEmployee(id);
	}
	 
	@DeleteMapping("/employeesDBDelete")
	public void  deleteTheEmployeeDetailsByid(@RequestParam("id") long id) {
		String deletevariable = "Deleted the Emp record "+id;
		this.eEmplyService.deleteEmployee(id);
	}
	
	
	@PutMapping("/employeesUpdateDB/{id}")
	public Employee updateEmpDB(@PathVariable long id, @RequestBody Employee employee) {
		System.out.println("Updating the exsiting data" + id);
		employee.setId(id);
		return this.eEmplyService.updateExsitingEmplRecord(employee);
	}
	
	
	
	//  ResponseEntity Converting 
	
	
	@GetMapping("/employeesResponse")
	public ResponseEntity<List<Employee>>getEmployees1ResponseEntity() {
		System.out.println("My First Spring Tools Project get from jpa");
		//return this.eEmplyService.getEmployees();
		return new ResponseEntity<List<Employee>>(eEmplyService.getEmployees(), HttpStatus.OK);
	}
	
	
	@GetMapping("/employeesDBResponse/{id}")
	public ResponseEntity<Employee> getEmplyeeByIdResponse(@PathVariable long id) {
		System.out.println("get the exsiting data  : "  + id);
		//return this.eEmplyService.getSingleEmployee(id);
		return new ResponseEntity<Employee>(this.eEmplyService.getSingleEmployee(id), HttpStatus.OK);
	}
	
	@PostMapping("/employeesDBReponse")
	public ResponseEntity<Employee> saveEmployeeResponse(@Valid @RequestBody Employee employee) {
		//return this.eEmplyService.saveEmpl(employee);
		return new ResponseEntity<>(this.eEmplyService.saveEmpl(employee), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/employeesUpdateDBResponse/{id}")
	public ResponseEntity<Employee> updateEmpDBResponse(@PathVariable long id, @RequestBody Employee employee) {
		System.out.println("Updating the exsiting data" + id);
		employee.setId(id);
		//return this.eEmplyService.updateExsitingEmplRecord(employee);
		return new ResponseEntity<Employee>(this.eEmplyService.updateExsitingEmplRecord(employee), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/employeesDBDeleteResponse")
	public ResponseEntity<HttpStatus>  deleteTheEmployeeDetailsByidResponse(@RequestParam("id") long id) {
		String deletevariable = "Deleted the Emp record "+id;
		//this.eEmplyService.deleteEmployee(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/employeesResponse/filterByName")
	public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name) {
		
		return new ResponseEntity<List<Employee>>(this.eEmplyService.getEmployeesByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/employeesResponse/filterByNameAndLocation")
	public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name, @RequestParam String location) {
		
		return new ResponseEntity<List<Employee>>(this.eEmplyService.getEmployeesByNameAndLocation(name,location), HttpStatus.OK);
	}
	
	@GetMapping("/employeesResponse/filterByNameKeyword")
	public ResponseEntity<List<Employee>> getEmployeesByNameKeyword(@RequestParam String name) {
		
		return new ResponseEntity<List<Employee>>(this.eEmplyService.getEmployeesByKeywordContains(name), HttpStatus.OK);
	}
	
	
	@GetMapping("/employeesResponse/{name}/{location}")
	public ResponseEntity<List<Employee>> getEmployeesByNameORLocation(@PathVariable String name, @PathVariable String location) {
		System.out.println("Search" + name + location);
		return new ResponseEntity<List<Employee>>(this.eEmplyService.getEmployeesByNameORLocationCheck(name,location), HttpStatus.OK);
	}
	
	///// Pages navigation
	
	
	@GetMapping("/employeesResponsePage")
	public ResponseEntity<List<Employee>>getEmployees1ResponseEntityPage(@RequestParam Integer pageNumbers, @RequestParam Integer pageSize) {
		System.out.println("Page number ");
		//return this.eEmplyService.getEmployees();
		return new ResponseEntity<List<Employee>>(eEmplyService.getEmployeesPages(pageNumbers, pageSize), HttpStatus.OK);
	}
	
//	@GetMapping("/employeesResponse/filterByNameKeywordSort")
//	public ResponseEntity<List<Employee>> getEmployeesByNameKeywordSort(@RequestParam String name) {
//		
//		return new ResponseEntity<List<Employee>>(this.eEmplyService.getEmployeesByKeywordSorting(name), HttpStatus.OK);
//	}
	
	
	
	@DeleteMapping("/employeesDeleteByNmae/delete/{name}")
	public ResponseEntity<String>  deleteTheEmployeeByNmae(@PathVariable("name") String name) {
//		String deletevariable = "Deleted the Emp record "+name;
		//this.eEmplyService.deleteByEmployeeame(name);
		return new ResponseEntity<String>(" No. of records deleted  :  " + this.eEmplyService.deleteByEmployeeame(name)+"  ", HttpStatus.OK);
	}
	
	
	
}
