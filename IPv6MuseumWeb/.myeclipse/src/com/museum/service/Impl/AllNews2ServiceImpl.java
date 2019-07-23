package com.museum.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.dao.IAllNews2Dao;
import com.museum.domain.Activity;
import com.museum.domain.News;
import com.museum.domain.Page;
import com.museum.service.IAllNews2Service;

@Service
@Transactional
public class AllNews2ServiceImpl implements IAllNews2Service {

	@Autowired
	private IAllNews2Dao dao;
	public void delete(Integer rid) {
		
	}

	public News find(News n) {
		return null;
	}

	public List<News> find() {
		return null;
	}

	public Page findPageData(int p, int size) {
		int rowCount = dao.getRowCount();
		Page page = new Page(p,rowCount,size);
		List<News> list = dao.find(page.getStartLine(),page.getSize());
		page.setList(list);
		return page;
	}

	public void save(News n) {
		
	}

	public void update(News r) {
		
	}

}
