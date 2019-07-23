package com.museum.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.dao.IAllNewsDao;
import com.museum.domain.News;

@Repository
public class AllNewsDaoImpl implements IAllNewsDao {

	@Autowired
	private SessionFactory sf;
	private Session getSession(){
		return sf.getCurrentSession();
	}
	public void delete(Integer rid) {
		
	}

	public News find(Integer n) {
		return null;
	}

	public List<News> find() {
		int i = getSession().createQuery("FROM News").list().size();	
		return getSession().createQuery("FROM News").list().subList(i-3, i);
	}

	public void save(News n) {
		
	}

	public void update(News r) {
		
	}

}
