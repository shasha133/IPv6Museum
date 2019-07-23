package com.museum.dao;

import java.util.List;

import com.museum.domain.Exhibits;

public interface ITJDao {
	public void save(Exhibits n);
	public Exhibits find(Integer n);
	public void delete(Integer rid);
	public void update(Exhibits r);
	public List<Exhibits> find(String str);
	
	public List<Exhibits> find(int startLine,int size,String str);
	public int getRowCount(String str);
}
