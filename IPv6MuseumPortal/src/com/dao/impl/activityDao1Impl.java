package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.IActivity1Dao;
import com.dao.INews1Dao;
import com.museum.domain.Activity;
import com.museum.domain.News;
import com.museum.domain.User;



@Repository
public class activityDao1Impl implements IActivity1Dao{
	@Autowired
	private SessionFactory sf;//自动注入Session工厂
	
	private Session getSession(){
		return  sf.getCurrentSession();
		
	}
	public void delete(Integer activityId) {
		Activity activity=(Activity) getSession().get(Activity.class,activityId);
		getSession().delete(activity);
		
	}
	public List<Activity> find() {
		return getSession().createQuery("FROM Activity").list();
	}
	public Activity find(Integer activityId) {
		Activity activity=(Activity) getSession().get(Activity.class, activityId);
		return activity;
	}
	public void save(Activity activity) {
		getSession().save(activity);
	}
	public void update(Activity activity) {
		getSession().update(activity);
	}
	public List<Activity> findBy(String str,String str1,String str2,String type) {
		  String hql = "from Activity where ( activityTitle=? or activityTime=? or activityId=? ) and Activity_Type_id=?";  
		  Query query = getSession().createQuery(hql);
		  query.setString(0, str);  
		  query.setString(1, str1);  
		  query.setString(2, str2); 
		  query.setString(3, type); 
		  List<Activity> list = query.list();  
		  return list;  
	}
	
	
	
	public List<Activity> find(int StratLine, int size,String type) { 
		Query q= getSession().createQuery("FROM Activity where Activity_Type_id=?");
		q.setString(0, type);  
		q.setFirstResult(StratLine);
		q.setMaxResults(size);
		return q.list();
	}//按起始行和行数进行分页操作
	public int getRowCount() { 
		long x=(Long) getSession().createQuery("SELECT COUNT(*) FROM Activity").uniqueResult();
		return (int) x;
	}//获取表中所有记录的行数
}
