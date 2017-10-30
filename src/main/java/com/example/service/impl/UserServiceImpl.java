package com.example.service.impl;

import com.example.bean.User;

public interface UserServiceImpl {
	
	public User findByID(long id);
	
	
	public User save(User user);
	

}
