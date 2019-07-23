package com.museum.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.dao.IExhibitsJP3Dao;
import com.museum.domain.Exhibits;

@Repository
public class ExhibitsJP3DaoImpl implements IExhibitsJP3Dao {

	@Autowired
	private SessionFactory sf;
	private Session getSession(){
		return sf.getCurrentSession();
	}
	public void delete(Integer rid) {
	}
	public Exhibits find(Integer n) {
		return null;
	}
	public List<Exhibits> find() {
		int i = getSession().createQuery("FROM Exhibits").list().size();	
		return getSession().createQuery("FROM Exhibits").list().subList(i-4, i-2);
	}
	public void save(Exhibits n) {
	}
	public void update(Exhibits r) {
	}

}
