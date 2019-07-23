package com.museum.service;

import java.util.List;

import com.museum.domain.Activity;
import com.museum.domain.Page;

public interface IAct2Service {
	public void save(Activity n);//增加
	public Activity find(Activity n);//查一条
	public void delete(Integer rid);//删除
	public void update(Activity r);//更新
	public List<Activity> find();//差所有
	
	public Page findPageData(int p,int size);//查询分页数据
}	
