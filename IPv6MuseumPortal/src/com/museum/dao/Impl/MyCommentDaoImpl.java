package com.museum.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.dao.IHallDao;
import com.museum.dao.IMyCommentDao;
import com.museum.domain.Comment;
import com.museum.domain.Exhibits;
import com.museum.domain.Hall;
import com.museum.domain.Reply;
import com.museum.domain.User;


@Repository
public class MyCommentDaoImpl implements IMyCommentDao {
	
	@Autowired
	private SessionFactory sf;
	private Session getSession(){
		return sf.getCurrentSession();
	}
	public void delete(Integer rid) {
	}
	public User find(Integer n) {
		return null;
	}
	public List<Comment> find(String str) {
		String hql = "from Comment where From_uid=?"; 
		Query query = getSession().createQuery(hql);
		query.setString(0, str); 
		List<Comment> list = query.list();  
		return list; 
	}
	public void save(User n) {
	}
	public void update(User r) {
	}
	public Exhibits findExhibits(Integer topicId) {
		String hql = "from Exhibits where Exhibits_id=?"; 
		Query query = getSession().createQuery(hql);
		query.setInteger(0, topicId); 
		return (Exhibits) query.list().get(0);
	}
	
}
