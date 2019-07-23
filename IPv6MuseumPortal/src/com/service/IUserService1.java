package com.service;

import java.util.List;

import com.museum.domain.News;
import com.museum.domain.Page;
import com.museum.domain.User;


public interface IUserService1 {
	public void save(User user);
	public void delete(String user_id);
	public void update(User user);
	public List<User> find();
	public User find(String user_id);
	

	public List<User> findBy(String str,String str1);

	public Page findPageData(int p,int size);
}
