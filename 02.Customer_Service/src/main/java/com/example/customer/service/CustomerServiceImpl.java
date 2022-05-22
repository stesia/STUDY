package com.example.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.entity.Customer;
import com.example.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}

	@Override
	public Customer findCustomerById(Long csId) {
		
		return customerRepository.findById(csId).get();
	}

}
