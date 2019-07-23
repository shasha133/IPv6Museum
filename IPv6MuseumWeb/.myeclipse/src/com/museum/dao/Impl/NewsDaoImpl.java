package com.museum.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.dao.INewsDao;
import com.museum.domain.News;


@Repository
public class NewsDaoImpl implements INewsDao{

	@Autowired
	private SessionFactory sf;
	private Session getSession(){
		return sf.getCurrentSession();
	}
	public News find(Integer n) {
		return null;
	}

	public void save(News n) {
		getSession().save(n);
	}
	public void delete(Integer rid) {
		News n = (News)getSession().get(News.class, rid);
		getSession().delete(n);
	}
	public List<News> find() {
		int i = getSession().createQuery("FROM News").list().size();	
		return getSession().createQuery("FROM News").list().subList(i-3, i);
	}
	public void update(News r) {
		
	}

}
