package com.example.mvc.service;

import java.util.List;

import com.example.mvc.entity.User;
import com.example.mvc.entity.UserDto;

public interface UserService {
	User findUserById(String id);
	List<User> findUsers();
	User createUser(User user);
	User deleteUser(String id);
	UserDto findUserDtoById(String id);
}
