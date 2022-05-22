package com.example.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.order.entity.Orders;

public interface OrderRepository extends CrudRepository<Orders, Long> {

}
