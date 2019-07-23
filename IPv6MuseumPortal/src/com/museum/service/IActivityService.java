package com.museum.service;

import java.util.List;

import com.museum.domain.Activity;

public interface IActivityService {
	public void save(Activity n);
	public Activity find(Integer n);
	public void delete(Integer rid);
	public void update(Activity r);
	public List<Activity> find();
}
