package com.example.customer.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.customer.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
