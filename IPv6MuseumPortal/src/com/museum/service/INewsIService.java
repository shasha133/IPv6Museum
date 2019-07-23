package com.museum.service;

import java.util.List;

import com.museum.domain.News;

public interface INewsIService {
	public void save(News n);
	public News find(News n);
	public void delete(Integer rid);
	public void update(News r);
	public List<News> find(String str);
}