package com.museum.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.dao.IAct2Dao;
import com.museum.domain.Activity;


@Repository
public class Act2DaoImpl implements IAct2Dao {

	
	@Autowired
	private SessionFactory sf;//引入hibernate框架的session
	private Session getSession(){
		return sf.getCurrentSession();
	}
	
	public void delete(Integer rid) {
		
	}

	public Activity find(Integer n) {
		return null;
	}

	public List<Activity> find() {
		return getSession().createQuery("FROM Activity").list();//查询并返回活动的list类型数据
	}

	public void save(Activity n) {
		
	}

	public void update(Activity r) {
		
	}

	public List<Activity> find(int startLine, int size) {
		Query q = getSession().createQuery("FROM Activity");//查询所有活动
		q.setFirstResult(startLine);//得到活动的起始行
		q.setMaxResults(size);//得到活动的最大页数，即共？页
		return q.list();
	}

	public int getRowCount() {
		long i = (Long)getSession().createQuery("SELECT COUNT(*) FROM Activity").uniqueResult();
		return (int) i;
	}

}
