package com.example.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa.entity.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
