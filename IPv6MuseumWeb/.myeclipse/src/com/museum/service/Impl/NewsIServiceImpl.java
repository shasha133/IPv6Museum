package com.museum.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.dao.INewsIDao;
import com.museum.domain.News;
import com.museum.service.INewsIService;

@Service
@Transactional
public class NewsIServiceImpl implements INewsIService {

	@Autowired
	private INewsIDao dao;
	public void delete(Integer rid) {
		
	}

	public News find(News n) {
		return null;
	}

	public List<News> find(String str) {
		return dao.find(str);
	}

	public void save(News n) {
		
	}

	public void update(News r) {
		
	}

}
