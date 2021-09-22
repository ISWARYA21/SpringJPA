package com.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.entity.User;
import com.jpa.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	@PostMapping("/user")
	public void addUser(@RequestBody User user) {	
		userService.addUser(user);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.findAllUsers();
	}
	
	@GetMapping("/user/{userid}")
	public User getUserById(@PathVariable("userid")int userId) {
		return userService.findUserById(userId);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUserById(id);
	}
	
	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

}
