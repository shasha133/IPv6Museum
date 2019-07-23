package com.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.IAdviceDao;
import com.museum.domain.Advice;


@Repository
public class AdviceDapImpl implements IAdviceDao{
	@Autowired
	private SessionFactory sf;//�Զ�ע��Session����
	
	private Session getSession(){
		return  sf.getCurrentSession();
		
	}

	public void delete(Integer adviceId) {
		getSession().delete(adviceId);
		
	}

	public void save(Advice advice) {
		getSession().save(advice);	
	}
}
