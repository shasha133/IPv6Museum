package com.museum.dao;

import java.util.List;

import com.museum.domain.Exhibits;

public interface IExhibitsJP3Dao {
	public void save(Exhibits n);
	public Exhibits find(Integer n);
	public void delete(Integer rid);
	public void update(Exhibits r);
	public List<Exhibits> find();
}