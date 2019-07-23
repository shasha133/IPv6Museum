package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ICollectDao;
import com.dao.INews1Dao;
import com.museum.domain.Activity;
import com.museum.domain.Collect;
import com.museum.domain.News;
import com.museum.domain.Page;
import com.service.ICollectService1;
import com.service.INewsService1;



@Service
@Transactional
public class CollectService1Impl implements ICollectService1{
	@Autowired
	private ICollectDao dao;
	public List<Collect> find() { 
		return dao.find();
	}
	public Collect find(Collect collectId) { 
		return dao.find(collectId);
	}
 
	public void delete(Integer collectId) {
		dao.delete(collectId);
	}
	public List<Collect> findBy(String str, String str1) { 
		return dao.findBy(str, str1);
	}
	public Page findPageData(int p, int size) { 
		int rowCount=dao.getRowCount();
		Page page=new Page(p, rowCount, size);
		List<Collect> list=dao.find(page.getStartLine(), page.getSize());
		page.setList(list);
		return page;
	}
	public void deleteUser(String UserId) {
		dao.deleteUser(UserId);
		
	}

	
}
