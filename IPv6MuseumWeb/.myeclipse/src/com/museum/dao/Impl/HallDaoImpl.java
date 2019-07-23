package com.museum.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.dao.IHallDao;
import com.museum.domain.Hall;


@Repository
public class HallDaoImpl implements IHallDao {
	
	@Autowired
	private SessionFactory sf;
	private Session getSession(){
		return sf.getCurrentSession();
	}
	public void delete(Integer rid) {
		
	}
	public Hall find(Integer n) {
		return null;
	}
	public List<Hall> find() {
		int i = getSession().createQuery("FROM Hall").list().size();	
		return getSession().createQuery("FROM Hall").list().subList(i-1, i);
	}
	public void save(Hall n) {
		
	}
	public void update(Hall r) {
		
	}
}
