package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Dao.UserDao;
import com.example.bean.User;
import com.example.service.impl.UserServiceImpl;
@Transactional
@Service
public class UserSevice implements UserServiceImpl{
	@Autowired
	private UserDao useDao;

	@Override
	public User findByID(long id) {
		return useDao.findOne(id);
	}

	public UserDao getUseDao() {
		return useDao;
	}

	public void setUseDao(UserDao useDao) {
		this.useDao = useDao;
	}

	@Override
	public User save(User user) {
		return useDao.save(user);
	}

	
	
}
