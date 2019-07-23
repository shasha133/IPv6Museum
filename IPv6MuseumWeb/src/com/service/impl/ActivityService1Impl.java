package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.IActivity1Dao;
import com.dao.INews1Dao;
import com.museum.domain.Activity;
import com.museum.domain.News;
import com.museum.domain.Page;
import com.service.IActivityService1;
import com.museum.service.INewsService;



@Service
@Transactional
public class ActivityService1Impl implements IActivityService1{
	@Autowired
	private IActivity1Dao dao;//自动注入IActivityDao
	
	public void save(Activity activity) {
		dao.save(activity);
		
	}

	public void update(Activity activity) {
		dao.update(activity);
	}

	public void delete(Integer activityId) {
		dao.delete(activityId);
	}

	public List<Activity> find() {
		// TODO Auto-generated method stub
		return dao.find();
	}

	public Activity find(Integer activityId) {
		// TODO Auto-generated method stub
		return dao.find(activityId);
	}
	public Page findPageData(int p, int size,String type) { 
		int rowCount=dao.getRowCount();
		Page page=new Page(p, rowCount, size);
		List<Activity> list=dao.find(page.getStartLine(), page.getSize(),type);
		page.setList(list);
		return page;
	}//根据page进行分页操作

	public List<Activity> findBy(String Activitytitle, String Activitytime,
			String ActivityId,String type) {
		return dao.findBy(Activitytitle, Activitytime, ActivityId,type);
	}//根据条件查找
}
