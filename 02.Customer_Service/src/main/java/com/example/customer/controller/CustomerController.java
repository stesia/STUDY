package com.example.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.entity.Customer;
import com.example.customer.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customer/{csId}")
	public Customer findCustomer(@PathVariable Long csId) throws Exception {
		Thread.sleep(10000);
		return customerService.findCustomerById(csId);
	}
	@PostMapping("/customer")
	public Customer createCustomer(Customer customer) {
		return customerService.createCustomer(customer);
	}

}
