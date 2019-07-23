package com.museum.dao;

import java.util.List;

import com.museum.domain.Activity;

public interface IAct2Dao {
	public void save(Activity n);
	public Activity find(Integer n);
	public void delete(Integer rid);
	public void update(Activity r);
	public List<Activity> find();
	
	public int getRowCount();//��ѯ������
	public List<Activity> find(int startLine,int size);//��ѯ��ҳ��Ϣ
}
