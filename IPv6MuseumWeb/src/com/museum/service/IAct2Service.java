package com.museum.service;

import java.util.List;

import com.museum.domain.Activity;
import com.museum.domain.Page;

public interface IAct2Service {
	public void save(Activity n);//����
	public Activity find(Activity n);//��һ��
	public void delete(Integer rid);//ɾ��
	public void update(Activity r);//����
	public List<Activity> find();//������
	
	public Page findPageData(int p,int size);//��ѯ��ҳ����
}	
