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
		int i = getSession().createQuery("FROM Exhibits WHERE Exhibits_id = "+str).list().size();	
		return getSession().createQuery("FROM Exhibits WHERE Exhibits_id = "+str).list().subList(i-1, i);
	}
	public void save(Record n) {
		getSession().save(n);
	}

	public void save2(Comment c) {
		getSession().save(c);
		System.out.println("success");
	}
	public void update(int r,String str) {
		getSession().createQuery("UPDATE Exhibits SET Exhibits_browse = Exhibits_browse+1 WHERE Exhibits_id ="+str).executeUpdate();
		
	}
	@SuppressWarnings("null")
	public List<User> find2(String str) {
		int i = getSession().createQuery("FROM Comment WHERE Topic_id = "+str).list().size();
		int ii = getSession().createQuery("FROM User WHERE User_id = "+str).list().size();
		List<String> iii = (List<String>)getSession().createQuery("SELECT fromUid FROM Comment WHERE Topic_id ="+str).list();
		List<User> list = new ArrayList<User>();
		User user = new User();
		if(i == 0 || ii == 0){
			return null;
		}else{
			for(String ss : iii){
				user = (User)getSession().get(User.class, ss);
				list.add(user);
			}
			return list;
		}
	}
	public List<Comment> find3(String str) {
		int i = getSession().createQuery("FROM Comment WHERE Topic_id = "+str).list().size();
		
		if(i>=5){
			return getSession().createQuery("FROM Comment WHERE Topic_id = "+str).list().subList(i-4, i);
		}else{
			return getSession().createQuery("FROM Comment WHERE Topic_id = "+str).list();
		}
	}

}
