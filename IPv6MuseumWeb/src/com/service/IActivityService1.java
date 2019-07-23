package com.service;

import java.util.List;

import com.museum.domain.Activity;
import com.museum.domain.News;
import com.museum.domain.Page;


public interface IActivityService1 {
	public void save(Activity activity);
	public void delete(Integer activityId);
	public void update(Activity activity);
	public List<Activity> find();
	public Activity find(Integer activityId);
	
	public Page findPageData(int p,int size,String type);
	public List<Activity> findBy(String Activitytitle, String Activitytime, String ActivityId,String type);
}
