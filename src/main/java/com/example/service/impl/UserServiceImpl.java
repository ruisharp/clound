package com.example.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.User;
@Transactional
@Service
public interface UserServiceImpl {
	
	public User findByID(long id);
	
	
	public User save(User user);
	

}
