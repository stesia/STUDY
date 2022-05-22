package com.example.mvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvc.entity.User;
import com.example.mvc.entity.UserDto;
import com.example.mvc.service.UserService;

@RestController //@Controller  + @ResponseBody 
public class UserController {	
	
	private static Logger LOGGER =
			LoggerFactory.getLogger(UserController.class);
	private static String TITLE ="Controller Request LOG: ";
	
	@Autowired
	UserService service;
	
	@GetMapping("/user/{id}")
	public /* @ResponseBody */ User findUser(@PathVariable String id){
		LOGGER.info(TITLE+id+"로 사용자를 조회합니다.");
		return service.findUserById(id);//JSON -> Default Message Converter : Jackson Mapper ->Object to Json, Json to Object
	}
	
	@GetMapping("/user/dto/{id}")
	public UserDto findUserDto(@PathVariable String id) {
		return service.findUserDtoById(id);
	}
	
	
	@GetMapping("/users")
	public /* @ResponseBody */ List<User> getUsers(){
		LOGGER.info(TITLE+"로 사용자 목록을 조회합니다.");
		return service.findUsers();//JSON
	}	
	//RESTful API -> GET: Read, POST: Create, PUT: Update, DELETE: delete
	@PostMapping("/user")
	public User createUser(/* @RequestBody */ User user) {
		LOGGER.info(TITLE+"로 "+user.getId()+"사용자 생성합니다.");
		return service.createUser(user);		
	}
	
	@DeleteMapping("/user/{id}")
	public User deleteUser(@PathVariable String id) {
		LOGGER.info(TITLE+id+" 사용자를 삭제합니다.");
		return service.deleteUser(id);
	}
}
