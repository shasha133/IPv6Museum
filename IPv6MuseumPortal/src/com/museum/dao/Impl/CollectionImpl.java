package com.museum.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.museum.dao.ICollection;
import com.museum.domain.Collect;
import com.museum.domain.Exhibits;
import com.museum.domain.User;

@Repository
public class CollectionImpl implements ICollection{
	@Autowired
	private SessionFactory sf;
	private Session getSession(){
		return sf.getCurrentSession();
	}
	public void delete(Integer collectId) { 
		Collect collect=(Collect) getSession().get(Collect.class,collectId);
		getSession().delete(collect);
	}
	public List<Collect> find(String userId) {
		  String hql = "From Collect where User_id=?";  
		  Query query = getSession().createQuery(hql);
		  query.setString(0, userId);  
		  List<Collect> list = query.list();  
		  return list; 
	}
	public Exhibits finde(int exhibitsId) {
		// TODO Auto-generated method stub
		return (Exhibits) getSession().get(Exhibits.class, exhibitsId);
	}

	public void save(Collect collect) {
		getSession().save(collect);
	}
	public void update(Exhibits exhibits) {
		getSession().update(exhibits);
	}
	@Override
	public User findu(String userId) {
		// TODO Auto-generated method stub
		return (User) getSession().get(User.class, userId);
	}


}
