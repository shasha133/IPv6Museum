package com.dao;

import java.util.List;

import com.museum.domain.Activity;
import com.museum.domain.News;



public interface IActivity1Dao {
	public void save(Activity activity);
	public void delete(Integer activityId);
	public void update(Activity activity);
	public List<Activity> find();
	public Activity find(Integer activityId);

	public List<Activity> findBy(String str,String str1,String str2,String type);
	
	public int getRowCount();
	public List<Activity> find(int StratLine,int size,String type);
}
