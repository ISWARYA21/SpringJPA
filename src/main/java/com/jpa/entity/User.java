package com.jpa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_master")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int userId;
	
	@Column(name = "name")
	private String userName;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Account> accounts =  new HashSet<>();
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Set<Account> getAccounts(){
		return accounts;
	}
	
	public void setAccounts(Set<Account> accounts){
		this.accounts = accounts;
		for(Account acct : accounts) {
			acct.setUser(this);
		}
	}
}