package com.museum.service;

import java.util.List;

import com.museum.domain.Hall;
import com.museum.domain.User;

public interface IUserService {
	public void save(User n);
	public User find(User n);
	public void delete(Integer rid);
	public void update(User r);
	public List<User> find(String str);
}