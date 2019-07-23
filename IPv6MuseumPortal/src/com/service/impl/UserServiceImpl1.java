package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.IUserDao1;
import com.museum.domain.News;
import com.museum.domain.Page;
import com.museum.domain.User;
import com.service.IUserService1;




@Service
@Transactional
public class UserServiceImpl1 implements IUserService1 {
	@Autowired
	private IUserDao1 dao;

	public List<User> find() {
		return dao.find();
	}

	public void save(User user) {
		dao.save(user);
	}

	public void update(User user) {
		dao.update(user);
	}

	public void delete(String userId) {
		dao.delete(userId);
	}

	public User find(String userId) {
		return dao.find(userId);
	}
	public List<User> findBy(String str,String str1) {
		List<User> list=dao.findBy(str, str1);
		return list;
	}

	
	
	public Page findPageData(int p, int size) { 
		int rowCount=dao.getRowCount();
		Page page=new Page(p, rowCount, size);
		List<User> list=dao.find(page.getStartLine(), page.getSize());
		page.setList(list);
		return page;
	}
}
