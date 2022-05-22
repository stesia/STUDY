package com.example.order.service;

import com.example.order.entity.Orders;

public interface OrderService {
	//CRUD 메서드 정의
	public Orders createOrder(Orders order);
	public Orders findOrderByNo(Long ordNo);
}
