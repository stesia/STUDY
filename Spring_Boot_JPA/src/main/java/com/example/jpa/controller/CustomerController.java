package com.example.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.CustomerDto;
import com.example.jpa.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService service;
	
	//Path : /customer
	@PostMapping("/customer")
	public CustomerDto createCustomer(CustomerDto customerDto) {
		
		return service.createCustomer(customerDto);
	}

	
}
