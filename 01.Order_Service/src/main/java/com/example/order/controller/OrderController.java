package com.example.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.entity.Orders;
import com.example.order.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService service;
	
	@GetMapping("/order/{ordNo}")
	public Orders findOrder(@PathVariable Long ordNo) {
		return service.findOrderByNo(ordNo);
	}
	@PostMapping("/order")
	public Orders createOrder(Orders order) {
		return service.createOrder(order);
	}
}
