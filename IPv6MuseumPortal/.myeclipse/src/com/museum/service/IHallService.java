package com.museum.service;

import java.util.List;

import com.museum.domain.Hall;

public interface IHallService {
	public void save(Hall n);
	public Hall find(Hall n);
	public void delete(Integer rid);
	public void update(Hall r);
	public List<Hall> find();
}
