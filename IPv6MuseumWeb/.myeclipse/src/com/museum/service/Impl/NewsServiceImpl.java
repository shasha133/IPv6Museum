package com.museum.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.dao.INewsDao;
import com.museum.domain.News;
import com.museum.service.INewsService;


@Service
@Transactional
public class NewsServiceImpl implements INewsService{

	@Autowired
	private INewsDao dao;
	
	public News find(Integer n) {
		return dao.find(n);
	}

	public void save(News n) {
		dao.save(n);
	}

	public void delete(Integer rid) {
		dao.delete(rid);
	}

	public List<News> find() {
		return dao.find();
	}

	public void update(News r) {
		
	}

}
