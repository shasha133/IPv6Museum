package com.service;

import java.util.List;

import com.museum.domain.Collect;
import com.museum.domain.News;
import com.museum.domain.Page;


public interface ICollectService1 {
	public void delete(Integer collectId);
	public List<Collect> find();
	public Collect find(Collect collectId);

	public void deleteUser(String UserId);
	public List<Collect> findBy(String str,String str1);
	
	public Page findPageData(int p,int size);
}
