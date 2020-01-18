package com.app.dao;

import java.util.List;

import com.app.pojos.User;

public interface IUserDao {
	
	User validateUser(String email,String password); 
	String addUser(User u);
	List<User> getAllUser();
	List<User> searchUser(String search);
}
