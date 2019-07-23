package com.dao;

import java.util.List;

import com.museum.domain.News;
import com.museum.domain.User;


public interface IUserDao1 {
	public void save(User user);
	public void delete(String userId);
	public void update(User user);
	public List<User> find();
	public User find(String userId);

	public List<User> findBy(String str,String str1);
	
	public int getRowCount();
	public List<User> find(int StratLine,int size);
}
