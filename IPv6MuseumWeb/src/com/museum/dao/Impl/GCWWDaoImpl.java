package com.museum.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.dao.IGCWWDao;
import com.museum.domain.Exhibits;

@Repository
public class GCWWDaoImpl implements IGCWWDao {

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
		
		int i = Integer.parseInt(str);
		Query q = getSession().createQuery("FROM Exhibits WHERE Material_id = "+i);
		q.setFirstResult(startLine);
		q.setMaxResults(size);
		return q.list();
	}
	
	public void save(Exhibits n) {
	}
	public void update(int r) {
	}
	public int getRowCount(String str) {
		int it = Integer.parseInt(str);
		long i = (Long)getSession().createQuery("SELECT COUNT(*) FROM Exhibits WHERE Material_id = "+it).uniqueResult();
		return (int) i;
	}
	public List<Exhibits> find2(int startLine, int size, String str) {
		int i = Integer.parseInt(str);
		Query q = getSession().createQuery("FROM Exhibits WHERE Hall_id = "+i);
		q.setFirstResult(startLine);
		q.setMaxResults(size);
		return q.list();
	}
	public int getRowCount2(String str) {
		int it = Integer.parseInt(str);
		long i = (Long)getSession().createQuery("SELECT COUNT(*) FROM Exhibits WHERE Hall_id = "+it).uniqueResult();
		return (int) i;
	}

}
