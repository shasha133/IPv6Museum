package com.dao;

import java.util.List;

import com.museum.domain.Record;



public interface IRecordDao {
	public void delete(Integer recordId);
	public List<Record> find();
	public Record find(Integer recordId);
	public List<Record> findBy(String str,String str1);
	public void deleteUser(String userId);
	public int getRowCount();
	public List<Record> find(int StratLine,int size);
}
