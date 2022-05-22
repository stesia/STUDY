package com.example.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.order.rest.entity.Customer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@Service
public class CustomerCompositeImpl implements CustomerComposite {
	@Value("${customer.api.url}")
	private String CUSTOMER_API_URL;
	
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(commandKey = "retrieveCustomer", fallbackMethod = "retrieveCustomerFallback")
	@Override
	public Customer findCustomerById(Long csId) {
		String restUrl=CUSTOMER_API_URL+"/customer/{csId}";
		return restTemplate
				.getForObject(restUrl, Customer.class, csId);
	}
	public Customer retrieveCustomerFallback(Long csId, Throwable t)throws Exception{
		System.out.println("ERROR : HystrixCommand work...");
		return null;
	}

}
