package com.museum.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.domain.Record;
import com.museum.dao.ICangPin2Dao;
import com.museum.domain.Comment;
import com.museum.domain.Exhibits;
import com.museum.domain.Reply;
import com.museum.domain.User;

@Repository
public class CangPin2DaoImpl implements ICangPin2Dao {

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
		String hql = "from Exhibits where Exhibits_id=?"; 
		Query query = getSession().createQuery(hql);
		query.setString(0, str); 
		List<Exhibits> list = query.list();  
		return list; 
	}
	public void save(Record n) {
		getSession().save(n);
	}

	public void save2(Comment c) {
		getSession().save(c);
	}
	public void update(int r,String str) {
		getSession().createQuery("UPDATE Exhibits SET Exhibits_browse = Exhibits_browse+1 WHERE Exhibits_id ="+str).executeUpdate();
		
	}
	@SuppressWarnings("null")
	public List<User> find2(String str) {
		String hql = "from User where User_id=?"; 
		Query query = getSession().createQuery(hql);
		query.setString(0, str); 
		List<User> list = query.list();  
		return list; 
	}
	public List<Comment> find3(String str) {
		String hql = "from Exhibits where Exhibits_name=?"; 
		Query query = getSession().createQuery(hql);
		query.setString(0, str); 
		int i = query.list().size();  
		
		if(i>=5){
			return query.list().subList(i-4, i);
		}else{
			return query.list();
		}
	}
	public List<Exhibits> find4(String str) {
		String hql = "from Exhibits where Exhibits_name=?"; 
		Query query = getSession().createQuery(hql);
		query.setString(0, str); 
		List<Exhibits> list = query.list();  
		return list; 
	}
	public Reply findReply(Integer r) {
		String hql = "from Reply where Comment_id=?"; 
		Query query = getSession().createQuery(hql);
		query.setInteger(0, r); 
		if(query.list().size()==0){
			return null;
		}else{
			return (Reply) query.list().get(0);
		}
	}

}
