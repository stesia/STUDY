package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController	// RESTful API
public class HellowController {

	@GetMapping("/")	// URL Mapping
	public String hellow() {
		return "Hellow Spring Boot";
	}
	
	@GetMapping("/hello/{message}")	// REST -> URL : Resource, @PathVariable
	//Json Mapper, Message Converter
	public String hello1(@PathVariable String message) {
		return "Hellow Spring Boot : " + message;
	}
}


