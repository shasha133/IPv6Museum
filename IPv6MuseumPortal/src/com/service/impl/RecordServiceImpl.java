package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.IActivity1Dao;
import com.dao.IRecordDao;
import com.museum.domain.Activity;
import com.museum.domain.Page;
import com.museum.domain.Record;
import com.service.IRecordService;



@Service
@Transactional
public class RecordServiceImpl implements IRecordService{
	@Autowired
	private IRecordDao dao;
	public void delete(Integer recordId) {
		dao.delete(recordId);
	}

	public List<Record> find() { 
		return dao.find();
	}

	public Record find(Integer recordId) { 
		return dao.find(recordId);
	}

	public List<Record> findBy(String str, String str1) { 
		return dao.findBy(str, str1);
	}

	public Page findPageData(int p, int size) { 
		int rowCount=dao.getRowCount();
		Page page=new Page(p, rowCount, size);
		List<Record> list=dao.find(page.getStartLine(), page.getSize());
		page.setList(list);
		return page;
	}

	public void deleteUser(String userId) {
		dao.deleteUser(userId);
	}

}
