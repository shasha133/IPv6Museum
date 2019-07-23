package com.museum.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.dao.IAct2Dao;
import com.museum.domain.Activity;
import com.museum.domain.Page;
import com.museum.service.IAct2Service;



@Service
@Transactional
public class Act2ServiceImpl implements IAct2Service {

	
	@Autowired
	private IAct2Dao dao;
	
	public void delete(Integer rid) {
		
	}

	public Activity find(Activity n) {
		return null;
	}

	public List<Activity> find() {
		return dao.find();
	}

	public void save(Activity n) {
		
	}

	public void update(Activity r) {
		
	}

	public Page findPageData(int p, int size) {
		int rowCount = dao.getRowCount();//查询总行数
		Page page = new Page(p,rowCount,size);//通过总行数计算出当前页数以及最大页数
		List<Activity> list = dao.find(page.getStartLine(),page.getSize());
		page.setList(list);
		return page;
	}

}
