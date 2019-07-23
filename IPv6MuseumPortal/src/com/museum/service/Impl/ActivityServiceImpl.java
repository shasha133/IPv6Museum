package com.museum.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.dao.IActivityDao;
import com.museum.domain.Activity;
import com.museum.service.IActivityService;


@Service
@Transactional
public class ActivityServiceImpl implements IActivityService {

	@Autowired
	private IActivityDao dao;
	
	public void delete(Integer rid) {
		
	}

	public Activity find(Integer n) {
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
