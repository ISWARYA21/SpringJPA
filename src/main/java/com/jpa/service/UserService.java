package com.jpa.service;

import java.util.List;

import com.jpa.entity.User;

public interface UserService {
	public void addUser(User user);
	public List<User> findAllUsers();
	public User findUserById(int id);
	public void deleteUserById(int id);
	public User updateUser(User user);
}