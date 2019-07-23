package com.museum.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.dao.IAllNewsDao;
import com.museum.domain.News;
import com.museum.service.IAllNewsService;

@Service
@Transactional
public class AllNewsServiceImpl implements IAllNewsService {

	@Autowired
	private IAllNewsDao dao;
	public void delete(Integer rid) {
		
	}

	public News find(Integer n) {
		return null;
	}

	public List<News> find() {
		return dao.find();
	}

	public void save(News n) {
		
	}

	public void update(News r) {
		
	}

}
