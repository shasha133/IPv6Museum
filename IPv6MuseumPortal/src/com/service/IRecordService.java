package com.service;

import java.util.List;

import com.museum.domain.News;
import com.museum.domain.Page;
import com.museum.domain.Record;


public interface IRecordService {
	public void delete(Integer recordId);
	public List<Record> find();
	public Record find(Integer recordId);
	public List<Record> findBy(String str,String str1);
	public void deleteUser(String userId);
	public Page findPageData(int p,int size);
}
