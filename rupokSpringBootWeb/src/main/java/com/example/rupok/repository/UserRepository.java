package com.example.rupok.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.rupok.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	public Iterable<User> deleteByUsername(String username);
	
	public User findByUsername(String username);

}
