package com.museum.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.dao.IActDao;
import com.museum.domain.Activity;
import com.museum.service.IActService;


@Service
@Transactional
public class ActServiceImpl implements IActService {

	@Autowired
	private IActDao dao;
	
	public void delete(Integer rid) {
		
	}

	public Activity find(Activity n) {
		return null;
	}

	public List<Activity> find() {
		return dao.find();
	}

	public void save(Activity n) {
		
	}

	public void update(Activity r) {
		
	}
	
}
