package com.museum.service;

import java.util.List;

import com.museum.domain.Exhibits;
import com.museum.domain.Page;

public interface IGCWWService {

	public void save(Exhibits n);
	public Exhibits find(Integer n);
	public void delete(Integer rid);
	public void update(int r);
	public List<Exhibits> find(String str);
	public Object findPageData(int i, int j,String str);
	public Page findPageData2(int i, int j, String str);
}