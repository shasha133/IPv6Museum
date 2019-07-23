package com.museum.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.dao.IGCWWDao;
import com.museum.dao.ITJDao;
import com.museum.domain.Exhibits;

@Repository
public class TJDaoImpl implements ITJDao {

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
		if(str.hashCode() == "Exhibits_upvote".hashCode() ){
			q = getSession().createQuery("FROM Exhibits Order By Exhibits_upvote desc");
		}else{
			q = getSession().createQuery("FROM Exhibits Order By Exhibits_browse desc");
		}
		
		q.setFirstResult(startLine);
		q.setMaxResults(size);
		return q.list();
	}
	
	public void save(Exhibits n) {
	}
	public void update(Exhibits r) {
	}
	public int getRowCount(String str) {
		long i = (Long)getSession().createQuery("SELECT COUNT(*) FROM Exhibits ").uniqueResult();
		return (int) i;
	}

}
