package com.museum.dao;

import java.util.List;

import com.museum.domain.Exhibits;

public interface IGCWWDao {
	public void save(Exhibits n);
	public Exhibits find(Integer n);
	public void delete(Integer rid);
	public void update(int r);
	public List<Exhibits> find(String str);
	
	public List<Exhibits> find(int startLine,int size,String str);
	public int getRowCount(String str);
	public int getRowCount2(String str);
	public List<Exhibits> find2(int startLine, int size, String str);
}
