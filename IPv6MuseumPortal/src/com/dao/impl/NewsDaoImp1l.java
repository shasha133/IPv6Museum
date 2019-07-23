package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.INews1Dao;
import com.museum.domain.News;
import com.museum.domain.User;



@Repository
public class NewsDaoImp1l implements INews1Dao{
	@Autowired
	private SessionFactory sf;
	
	private Session getSession(){
		return  sf.getCurrentSession();
		
	}
	public void delete(Integer newsId) {
		News news=(News) getSession().get(News.class, newsId);
		getSession().delete(news);
		
	}
	public List<News> find() {
		return getSession().createQuery("FROM News").list();
	}
	public News find(Integer newsId) {
		News news=(News) getSession().get(News.class, newsId);
		return news;
	}
	public void save(News news) {
		getSession().save(news);
	}
	public void update(News news) {
		getSession().update(news);
	}
	public List<News> findBy(String str,String str1,String str2) {
		  String hql = "from News where newsTitle=? or newsTime=? or newsId=?";  
		  Query query = getSession().createQuery(hql);
		  query.setString(0, str);  
		  query.setString(1, str1);  
		  query.setString(2, str2); 
		  List<News> list = query.list();  
		  return list;  
	}
	public List<News> find(int StratLine, int size) { 
		Query q= getSession().createQuery("FROM News");
		q.setFirstResult(StratLine);
		q.setMaxResults(size);
		return q.list();
	}
	public int getRowCount() { 
		long x=(Long) getSession().createQuery("SELECT COUNT(*) FROM News").uniqueResult();
		return (int) x;
	}
}
