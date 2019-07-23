package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.IRecordDao;
import com.museum.domain.Activity;
import com.museum.domain.Record;



@Repository
public class RecordDaoImpl implements IRecordDao{
	@Autowired
	private SessionFactory sf;
	
	private Session getSession(){
		return  sf.getCurrentSession();
		
	}
	public void delete(Integer recordId) {
		Record recored=(Record) getSession().get(Record.class,recordId);
		getSession().delete(recored);
	}

	public List<Record> find() { 
		return  getSession().createQuery("FROM Record").list();
	}

	public Record find(Integer recordId) {
		Record recored=(Record) getSession().get(Record.class,recordId);
		return recored;
	}
	public List<Record> findBy(String str, String str1) {
		String hql = "from Record where Record_exhibit_id=? or User_id=? ";  
		Query query = getSession().createQuery(hql);
		query.setString(0, str);  
		query.setString(1, str1); 
		List<Record> list = query.list();  
		return list; 
	}

	public List<Record> find(int StratLine, int size) { 
		Query q= getSession().createQuery("FROM Record ");
		q.setFirstResult(StratLine);
		q.setMaxResults(size);
		return q.list();
	}


	public int getRowCount() {
		long x=(Long) getSession().createQuery("SELECT COUNT(*) FROM Record").uniqueResult();
		return (int) x;
	}
	public void deleteUser(String userId) {
		String hql = "DELETE FROM Record where User_id=? ";  
		Query query = getSession().createQuery(hql);
		query.setString(0, userId);  
		query.executeUpdate();
	}

}
