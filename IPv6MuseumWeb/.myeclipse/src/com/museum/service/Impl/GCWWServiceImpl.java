package com.museum.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.dao.IGCWWDao;
import com.museum.domain.Activity;
import com.museum.domain.Exhibits;
import com.museum.domain.Page;
import com.museum.service.IGCWWService;

@Service
@Transactional
public class GCWWServiceImpl implements IGCWWService {

	@Autowired
	private IGCWWDao dao;
	
	public void delete(Integer rid) {
	}
	public Exhibits find(Integer n) {
		return null;
	}
	public List<Exhibits> find(String str) {
		return null;
	}
	public Object findPageData(int i, int j,String str) {
		int rowCount = dao.getRowCount(str);
		Page page = new Page(i,rowCount,j);
		List<Exhibits> list = dao.find(page.getStartLine(),page.getSize(),str);
		page.setList(list);
		return page;
	}
	public void save(Exhibits n) {
	}
	public void update(int r) {
	}

}
