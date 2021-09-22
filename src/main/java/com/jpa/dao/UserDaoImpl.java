package com.jpa.dao;

import java.util.List;
import com.jpa.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addUser(User user) {
		em.persist(user);
	}
	
	@Override
	public List<User> findAllUsers(){
		List<User> users = em.createQuery("Select distinct u from User u join fetch u.accounts",User.class).getResultList();
		return users;
	}
	
	@Override
	public User findUserById(int id) {
		return em.find(User.class, id);
	}

	
	@Override
	public void deleteUserById(int id) {
		User user = findUserById(id);
		if(user != null)
			em.remove(user);
		// TODO Auto-generated method stub
		
	}

	@Override
	public User updateUser(User user) {
		return em.merge(user);
		// TODO Auto-generated method stub
	}
}