package com.example.demo;

import org.springframework.beans.factory.annotation.Required;

public class SpringBootApplicationAnnotation {
	private Integer cost;  
	@Required    // It applies to the bean setter method. It indicates that the annotated bean must be populated at configuration time with the required property,
	public void setCost(Integer cost)   
	{  
	this.cost = cost;  
	}  
	public Integer getCost()   
	{  
	return cost;  
	}     

}
