package com.dao;

import java.util.List;

import com.museum.domain.News;



public interface INews1Dao {
	public void save(News news);
	public void delete(Integer newsId);
	public void update(News news);
	public List<News> find();
	public News find(Integer newsId);
	public List<News> findBy(String str,String str1,String str2);
	
	public int getRowCount();
	public List<News> find(int StratLine,int size);
}
