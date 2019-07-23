package com.museum.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.dao.IActivityIDao;
import com.museum.domain.Activity;
import com.museum.service.IActivityIService;

@Service
@Transactional
public class ActivityIServiceImpl implements IActivityIService {

	@Autowired
	private IActivityIDao dao;
	public void delete(Integer rid) {
	}
	public Activity find(Activity n) {
		return null;
	}
	public List<Activity> find(String str) {
		return dao.find(str);
	}
	public void save(Activity n) {
	}
	public void update(Activity r) {
	}
}
