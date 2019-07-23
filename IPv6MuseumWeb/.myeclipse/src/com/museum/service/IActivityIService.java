package com.museum.service;

import java.util.List;

import com.museum.domain.Activity;

public interface IActivityIService {
	public void save(Activity n);
	public Activity find(Activity n);
	public void delete(Integer rid);
	public void update(Activity r);
	public List<Activity> find(String str);
}