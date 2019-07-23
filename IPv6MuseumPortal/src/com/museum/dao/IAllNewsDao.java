package com.museum.dao;

import java.util.List;

import com.museum.domain.News;
import com.museum.domain.News;



public interface IAllNewsDao {
	public void save(News n);
	public News find(Integer n);
	public void delete(Integer rid);
	public void update(News r);
	public List<News> find();
}