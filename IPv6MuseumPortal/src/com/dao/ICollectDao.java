package com.dao;

import java.util.List;

import com.museum.domain.Activity;
import com.museum.domain.Collect;
import com.museum.domain.News;
import com.museum.domain.Record;



public interface ICollectDao {
	public void delete(Integer collectId);
	public List<Collect> find();
	public Collect find(Collect collectId);
	public void deleteUser(String UserId);
	
	public List<Collect> findBy(String str,String str1);
	
	public int getRowCount();
	public List<Collect> find(int StratLine,int size);
}
