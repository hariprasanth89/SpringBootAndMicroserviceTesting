package com.demo.info.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "tbl_employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id")
	private long id;
	
	//@Column(name = "name")  //Not required 
	//@NotNull(message = "Name should not be null")
	//@NotEmpty(message = "Name should not be null")
	@NotBlank(message = "Name should not be null")
	private String name;
	//@Column(name = "age")
	private long age = 0l;
	//@Column(name = "location")
	private String location;
	
	//@Column(name = "email")
	@Email(message = "Please enter the valid email address")
	private String email;
	//@Column(name = "department")
//	@NotNull(message = "Department sgould not be null")
	//@NotEmpty(message = "Department sgould not be null")
	@NotBlank(message = "Department should not be null")
	private String department;
	//private Employee emp; 
	
	@CreationTimestamp
	@Column(name = "created_at",nullable = false, updatable = false)  
	private Date created_at;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updated_at;
	
}
