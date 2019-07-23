package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.IUserDao1;
import com.museum.domain.News;
import com.museum.domain.User;


@Repository
public class USerDaoImpl1 implements IUserDao1 {
	@Autowired
	private SessionFactory sf;
	
	private Session getSession(){
		return  sf.getCurrentSession();
		
	}
	public void delete(String userId) {
		User user=(User) getSession().get(User.class, userId);
		getSession().delete(user);
		
	}
	public List<User> find() {
		return getSession().createQuery("FROM User").list();
	}
	public User find(String userId) {
		User user=(User) getSession().get(User.class, userId);
		return user;
	}
	public void save(User user) {
		getSession().save(user);
	}
	public void update(User user) {
		getSession().update(user);
	}
	public List<User> findBy(String str,String str1) {
		  String hql = "from User where userId=? or userName=?";  
		  Query query = getSession().createQuery(hql);
		  query.setString(0, str);  
		  query.setString(1, str1);  
		  List<User> list = query.list();  
		  return list;  
	}
	
	public List<User> find(int StratLine, int size) { 
		Query q= getSession().createQuery("FROM User");
		q.setFirstResult(StratLine);
		q.setMaxResults(size);
		return q.list();
	}
	public int getRowCount() { 
		long x=(Long) getSession().createQuery("SELECT COUNT(*) FROM User").uniqueResult();
		return (int) x;
	}
}
