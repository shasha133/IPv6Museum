package com.museum.dao;

import java.util.List;

import com.museum.domain.Hall;
import com.museum.domain.User;

public interface IUserDao {
	public void save(User n);
	public User find(Integer n);
	public void delete(Integer rid);
	public void update(User r);
	public List<User> find(String str);
}
