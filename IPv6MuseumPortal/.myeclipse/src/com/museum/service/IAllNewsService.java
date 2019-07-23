package com.museum.service;

import java.util.List;

import com.museum.domain.News;

public interface IAllNewsService {

	public void save(News n);
	public News find(Integer n);
	public void delete(Integer rid);
	public void update(News r);
	public List<News> find();
}