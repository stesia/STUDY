package com.example.jpa.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.entity.Customer;
import com.example.jpa.entity.CustomerDto;
import com.example.jpa.repository.CustomerRepository;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;
	@Override
	public CustomerDto createCustomer(CustomerDto dto) {
		Customer entity = Customer
							.builder()
							.name(dto.getName())
							.address(dto.getAddress())
							.build();
		BeanUtils.copyProperties(dto, entity);
		entity = repository.save(entity);
		BeanUtils.copyProperties(entity, dto);
		
		return dto;
	}
	
}
