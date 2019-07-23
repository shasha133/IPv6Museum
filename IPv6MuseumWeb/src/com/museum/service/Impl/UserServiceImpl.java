package com.museum.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.dao.IUserDao;
import com.museum.domain.User;
import com.museum.service.IUserService;


@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;
	
	public void delete(Integer rid) {
		
	}

	public User find(User n) {
		return null;
	}

	public List<User> find(String str) {
		return dao.find(str);
	}

	public void save(User n) {
		
	}

	public void update(User r) {
		
	}

}
