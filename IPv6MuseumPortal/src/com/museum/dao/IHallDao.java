package com.museum.dao;

import java.util.List;

import com.museum.domain.Hall;

public interface IHallDao {
	public void save(Hall n);
	public Hall find(Integer n);
	public void delete(Integer rid);
	public void update(Hall r);
	public List<Hall> find();
}
