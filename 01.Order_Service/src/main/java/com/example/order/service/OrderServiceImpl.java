package com.example.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.order.entity.Orders;
import com.example.order.repository.OrderRepository;
import com.example.order.rest.CustomerComposite;
import com.example.order.rest.entity.Customer;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	CustomerComposite customerComposite;

	@Override
	public Orders createOrder(Orders order) {
		Customer customer=customerComposite
				.findCustomerById(order.getCsId());
		order.setCsName(customer.getCsName());
		return orderRepository.save(order);
	}

	@Override
	public Orders findOrderByNo(Long ordNo) {		
		return orderRepository.findById(ordNo).get();
	}
}
