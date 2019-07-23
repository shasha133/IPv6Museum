package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.INews1Dao;
import com.museum.domain.News;
import com.museum.domain.Page;
import com.museum.domain.User;
import com.service.INewsService1;



@Service
@Transactional
public class NewsService1Impl implements INewsService1{
	@Autowired
	private INews1Dao dao;
	public void delete(Integer newsId) {
		dao.delete(newsId);
	}

	public List<News> find() {
		return dao.find();
	}

	public News find(Integer newsId) {
		return dao.find(newsId);
	}

	public void save(News news) {
		dao.save(news);
	}

	public void update(News news) {
		dao.update(news);
	}

	public List<News> findBy(String str,String str1,String str2) {
		List<News> list=dao.findBy(str, str1, str2);
		return list;
	}

	public Page findPageData(int p, int size) { 
		int rowCount=dao.getRowCount();
		Page page=new Page(p, rowCount, size);
		List<News> list=dao.find(page.getStartLine(), page.getSize());
		page.setList(list);
		return page;
	}

}
