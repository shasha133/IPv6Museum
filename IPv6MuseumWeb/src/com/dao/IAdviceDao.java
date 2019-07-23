package com.dao;

import com.museum.domain.Advice;

public interface IAdviceDao {
	public void save(Advice advice);
	public void delete(Integer adviceId);
	
}
