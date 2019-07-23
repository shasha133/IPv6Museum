package com.museum.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.dao.IAllNews2Dao;
import com.museum.domain.News;

@Repository
public class AllNews2DaoImpl implements IAllNews2Dao {

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
		return null;
	}

	public List<News> find(int startLine, int size) {
		Query q = getSession().createQuery("FROM News");
		q.setFirstResult(startLine);
		q.setMaxResults(size);
		return q.list();
	}

	public int getRowCount() {
		long i = (Long)getSession().createQuery("SELECT COUNT(*) FROM News").uniqueResult();
		return (int) i;
	}

	public void save(News n) {
		
	}

	public void update(News r) {
		
	}

}
