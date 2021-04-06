package com.example.rupok.Controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.rupok.Service.UserService;
import com.example.rupok.model.User;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/save-user")
	@Transactional
	public String registerUser(@RequestBody User user) {
		service.saveMyUser(user);
		return "Hello "+user.getFirstname()+"!! your registration is sucessfull";
	}
	
	@GetMapping("/all-users")
	public Iterable<User> showAllUser() {
		return service.showAllUser();
	}
	
	@GetMapping("/delete/{username}")
	@Transactional
	public Iterable<User> delleteUser(@PathVariable String username){
		return service.deleteUserByUsername(username);
	}
	
	@GetMapping("/search/{username}")
	public User searchUser(@PathVariable String username) {
		return service.findByUsername(username);
		
	}
	
}
