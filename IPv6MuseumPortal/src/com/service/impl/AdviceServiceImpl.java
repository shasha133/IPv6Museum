package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.IActivity1Dao;
import com.dao.IAdviceDao;
import com.museum.domain.Advice;
import com.service.IAdviceService;


@Service
@Transactional
public class AdviceServiceImpl implements IAdviceService{

	@Autowired
	private IAdviceDao dao;//×Ô¶¯×¢ÈëIActivityDao
	
	public void delete(Integer adviceId) {
		// TODO Auto-generated method stub
		dao.delete(adviceId);
	}

	public void save(Advice advice) {
		// TODO Auto-generated method stub
		dao.save(advice);
	}

}
