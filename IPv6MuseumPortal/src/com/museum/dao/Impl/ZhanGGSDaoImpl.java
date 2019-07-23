package com.museum.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.dao.IHallDao;
import com.museum.dao.IZhanGGSDao;
import com.museum.domain.Exhibits;
import com.museum.domain.Hall;


@Repository
public class ZhanGGSDaoImpl implements IZhanGGSDao {
	
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
	public List<Exhibits> find1() {
		int i = getSession().createQuery("FROM Exhibits WHERE Hall_id = 1").list().size();	
		return getSession().createQuery("FROM Exhibits").list().subList(i-2, i);
	}
	public List<Exhibits> find2() {
		int i = getSession().createQuery("FROM Exhibits WHERE Hall_id = 2").list().size();	
		return getSession().createQuery("FROM Exhibits").list().subList(i-2, i);
	}
	public List<Exhibits> find3() {
		int i = getSession().createQuery("FROM Exhibits WHERE Hall_id = 3").list().size();	
		return getSession().createQuery("FROM Exhibits").list().subList(i-2, i);
	}
	public List<Exhibits> find4() {
		int i = getSession().createQuery("FROM Exhibits WHERE Hall_id = 4").list().size();	
		return getSession().createQuery("FROM Exhibits").list().subList(i-2, i);
	}
	public List<Exhibits> find5() {
		int i = getSession().createQuery("FROM Exhibits WHERE Hall_id = 5").list().size();	
		return getSession().createQuery("FROM Exhibits").list().subList(i-2, i);
	}
	public List<Exhibits> find6() {
		int i = getSession().createQuery("FROM Exhibits WHERE Hall_id = 6").list().size();	
		return getSession().createQuery("FROM Exhibits").list().subList(i-2, i);
	}
	public void save(Exhibits n) {
	}
	public void update(Exhibits r) {
	}
	
}
