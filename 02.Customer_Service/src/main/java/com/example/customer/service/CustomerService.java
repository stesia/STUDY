package com.example.customer.service;

import com.example.customer.entity.Customer;


public interface CustomerService {
	public Customer createCustomer(Customer customer);
	public Customer findCustomerById(Long csId);	
}
