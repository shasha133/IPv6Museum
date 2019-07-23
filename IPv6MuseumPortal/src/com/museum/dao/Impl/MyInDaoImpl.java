package com.museum.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.dao.ICollDao;
import com.museum.dao.IGCWWDao;
import com.museum.dao.ImyInDao;
import com.museum.dao.ImyselfDao;
import com.museum.domain.Exhibits;
import com.museum.domain.User;

@Repository
public class MyInDaoImpl implements ImyInDao {

	@Autowired
	private SessionFactory sf;
	private Session getSession(){
		return sf.getCurrentSession();
	}
	public void delete(Integer rid) {
	}
	public User find(Integer n) {
		return null;
	}
	public List<User> find(String str) {
		String hql = "from User where User_id=?"; 
		Query query = getSession().createQuery(hql);
		query.setString(0, str); 
		List<User> list = query.list();  
		return list; 
	}
	
	public void save(User n) {
	}
	public void update(User r) {
		getSession().update(r);
	}

}
