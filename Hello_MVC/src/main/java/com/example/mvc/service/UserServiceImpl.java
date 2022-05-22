package com.example.mvc.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.mvc.entity.User;
import com.example.mvc.entity.UserDto;
import com.example.mvc.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository repository;	
	
	public UserServiceImpl(UserRepository repository) {
		this.repository=repository;
	}
	
	public User findUserById(String id) {		
		return repository.findUser(id);
	}
	
	public List<User> findUsers() {		
		return repository.findUsers();
	}

	@Override
	public User createUser(User user) {		
		return repository.createUser(user);
	}

	@Override
	public User deleteUser(String id) {		
		return repository.deleteUser(id);
	}

	
	public UserDto findUserDtoById(String id) {
		User entity=findUserById(id);
		UserDto dto = UserDto.builder().build();
		BeanUtils.copyProperties(entity,dto);
		return dto;
	}
	
}
