package com.museum.service;

import java.util.List;

import com.museum.domain.News;
import com.museum.domain.Page;

public interface IAllNews2Service {
	public void save(News n);
	public News find(News n);
	public void delete(Integer rid);
	public void update(News r);
	public List<News> find();
	
	public Page findPageData(int p,int size);
}	
