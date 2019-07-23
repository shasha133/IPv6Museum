package com.museum.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.dao.INewsIDao;
import com.museum.domain.News;

@Repository
public class NewsIDaoImpl implements INewsIDao {

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

	public List<News> find(String str) {
		int i = getSession().createQuery("FROM News WHERE News_id = "+str).list().size();	
		return getSession().createQuery("FROM News WHERE News_id = "+str).list().subList(i-1, i);
	}
	public void save(News n) {
		
	}
	public void update(News r) {
		
	}

}
