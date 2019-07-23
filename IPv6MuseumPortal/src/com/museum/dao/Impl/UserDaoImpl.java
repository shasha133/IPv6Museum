package com.museum.dao.Impl;

import java.util.List;

import org.apache.taglibs.standard.tag.common.core.SetSupport;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.dao.IHallDao;
import com.museum.dao.IUserDao;
import com.museum.domain.Hall;
import com.museum.domain.User;


@Repository
public class UserDaoImpl implements IUserDao {
	
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
	public List<User> find(String str) {
		String hql = "FROM User WHERE User_id = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, str);
		return query.list();
	}
	public void save(User n) {
		
	}
	public void update(User r) {
		
	}
}
