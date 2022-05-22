package com.example.mvc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.mvc.entity.User;

@Repository
public class UserRepository {
	private List<User> db= new ArrayList<>();
	{
		db.add(User
				.builder()				
				.name("HONG")
				.id("1")
				.build()
			);
		db.add(new User("2", "KIM"));
	}	
	public User findUser(String id) {
		for(User user:db) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}
	public List<User> findUsers(){
		return db;
	}
	
	public User createUser(User user) {	
		db.add(user);
		return findUser(user.getId());
	}
	public User deleteUser(String id) {	
		User user=findUser(id);
		db.remove(user);
		return user;
	}
}
