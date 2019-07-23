package com.museum.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.dao.ICollDao;
import com.museum.dao.IGCWWDao;
import com.museum.dao.ITJDao;
import com.museum.dao.ImyInDao;
import com.museum.dao.ImyselfDao;
import com.museum.domain.Activity;
import com.museum.domain.Exhibits;
import com.museum.domain.Page;
import com.museum.domain.User;
import com.museum.service.ICollService;
import com.museum.service.IGCWWService;
import com.museum.service.ImyInService;
import com.museum.service.ImyselfService;

@Service
@Transactional
public class MyInServiceImpl implements ImyInService {

	@Autowired
	private ImyInDao dao;
	
	public void delete(Integer rid) {
	}
	public User find(Integer n) {
		return null;
	}
	public List<User> find(String str) {
		return dao.find(str);
	}
	public void save(User n) {
	}
	public void update(User r) {
		dao.update(r);
	}

}
