package com.museum.service;

import java.util.List;

import com.museum.domain.Exhibits;

public interface ImyselfService {

	public void save(Exhibits n);
	public Exhibits find(Integer n);
	public void delete(Integer rid);
	public void update(Exhibits r);
	public List<Exhibits> find(String str);
	public Object findPageData(int i, int j,String str);
}