package com.service;

import java.util.List;

import com.museum.domain.News;
import com.museum.domain.Page;


public interface INewsService1 {
	public void save(News news);
	public void delete(Integer newsId);
	public void update(News news);
	public List<News> find();
	public News find(Integer newsId);
	public List<News> findBy(String str,String str1,String str2);
	
	public Page findPageData(int p,int size);
}
