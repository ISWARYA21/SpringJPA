package com.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.dao.UserDao;
import com.jpa.entity.User;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;
	
	@Override
	@Transactional
	public void addUser(User user) {
		dao.addUser(user);
	}
	@Override
	public List<User> findAllUsers(){
		return dao.findAllUsers();
	}
	@Override
	public User findUserById(int id) {
		User user = dao.findUserById(id);
		return user;
	}
	@Override
	@Transactional
	public void deleteUserById(int id) {
		dao.deleteUserById(id);
	}
	@Override
	@Transactional
	public User updateUser(User user) {
		User u = dao.findUserById(user.getUserId());
		u.setUserName(user.getUserName());
		if(u != null) {
			return dao.updateUser(u);
		}
		return null;
	}
}