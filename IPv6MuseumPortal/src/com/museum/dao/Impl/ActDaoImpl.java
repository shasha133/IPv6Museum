package com.museum.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.dao.IActDao;
import com.museum.domain.Activity;



@Repository
public class ActDaoImpl implements IActDao {

	
	@Autowired
	private SessionFactory sf;
	private Session getSession(){
		return sf.getCurrentSession();
	}
	
	public void delete(Integer rid) {
		
	}

	public Activity find(Integer n) {
		return null;
	}

	public List<Activity> find() {
		int i = getSession().createQuery("FROM Activity").list().size();
		return getSession().createQuery("FROM Activity").list().subList(i-3, i);
	}

	public void save(Activity n) {
		
	}

	public void update(Activity r) {
		
	}
	
}
