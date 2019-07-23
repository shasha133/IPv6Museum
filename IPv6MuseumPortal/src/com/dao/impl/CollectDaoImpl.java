package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.ICollectDao;
import com.dao.INews1Dao;
import com.museum.domain.Collect;
import com.museum.domain.News;
import com.museum.domain.Record;
import com.museum.domain.User;



@Repository
public class CollectDaoImpl implements ICollectDao{
	@Autowired
	private SessionFactory sf;
	
	private Session getSession(){
		return  sf.getCurrentSession();
		
	}
	public void delete(Integer collectId) {
		Collect collect=(Collect) getSession().get(Collect.class, collectId);
		getSession().delete(collect);
		
	}
	
	public Collect find(Collect collectId) {
		Collect collect=(Collect)getSession().get(Collect.class, collectId);
		return collect;
	}
  
	public List<Collect> find() { 
		return getSession().createQuery("FROM Collect").list();
	}
	public List<Collect> find(int StratLine, int size) { 
		Query q= getSession().createQuery("FROM Collect ");
		q.setFirstResult(StratLine);
		q.setMaxResults(size);
		return q.list();
	}
	public List<Collect> findBy(String str, String str1) { 
		String hql = "from Collect where Collect_exhibit_id=? or User_id=? ";  
		Query query = getSession().createQuery(hql);
		query.setString(0, str);  
		query.setString(1, str1); 
		List<Collect> list = query.list();  
		return list; 
	}
	public int getRowCount() { 
		long x=(Long) getSession().createQuery("SELECT COUNT(*) FROM Collect").uniqueResult();
		return (int) x;
	}
	public void deleteUser(String UserId) {
		String hql = "DELETE FROM Collect where User_id=? ";  
		Query query = getSession().createQuery(hql);
		query.setString(0, UserId);  
		query.executeUpdate();
	}
}
