package com.museum.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.dao.ICollDao;
import com.museum.dao.IGCWWDao;
import com.museum.dao.ImyselfDao;
import com.museum.domain.Exhibits;

@Repository
public class myselfDaoImpl implements ImyselfDao {

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
	public List<Exhibits> find(String str) {
		return null;
	}
	public List<Exhibits> find(int startLine, int size,String str) {
		Query q;
		q = getSession().createQuery("FROM Record Order By Record_id desc WHERE User_id = "+str);
		q.setFirstResult(startLine);
		q.setMaxResults(size);
		return q.list();
	}
	
	public void save(Exhibits n) {
	}
	public void update(Exhibits r) {
	}
	public int getRowCount(String str) {
		long i = (Long)getSession().createQuery("SELECT COUNT(*) FROM Record ").uniqueResult();
		return (int) i;
	}

}
