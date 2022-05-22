package com.example.order.rest;

import com.example.order.rest.entity.Customer;

public interface CustomerComposite {
	Customer findCustomerById(Long csId);
}
