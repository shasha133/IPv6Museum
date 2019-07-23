package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.IActivity1Dao;
import com.dao.IExhibitsDao1;
import com.dao.INews1Dao;
import com.museum.domain.Activity;
import com.museum.domain.Apply;
import com.museum.domain.Dynasty;
import com.museum.domain.Exhibits;
import com.museum.domain.Hall;
import com.museum.domain.Material;
import com.museum.domain.Nation;
import com.museum.domain.News;
import com.museum.domain.Page;
import com.museum.domain.Religion;
import com.museum.domain.State;
import com.museum.domain.Value;
import com.service.IActivityService1;
import com.service.IExhibitsService1;
import com.service.INewsService1;



@Service
@Transactional
public class ExhibitsService1Impl implements IExhibitsService1{
	@Autowired
	private IExhibitsDao1 dao;
	
	public void save(Exhibits activity) {
		dao.save(activity);
		
	}

	public void update(Exhibits activity) {
		dao.update(activity);
	}

	public void delete(Integer activityId) {
		dao.delete(activityId);
	}

	public List<Exhibits> find() {
		// TODO Auto-generated method stub
		return dao.find();
	}

	public Exhibits find(Integer exhibitsId) {
		// TODO Auto-generated method stub
		return dao.find(exhibitsId);
	}
	public Page findPageData(int p, int size) { 
		int rowCount=dao.getRowCount();
		Page page=new Page(p, rowCount, size);
		List<Exhibits> list=dao.find(page.getStartLine(), page.getSize());
		page.setList(list);
		return page;
	}



	public List<Apply> findA() {
		// TODO Auto-generated method stub
		return dao.findA();
	}

	public List<Dynasty> findD() {
		// TODO Auto-generated method stub
		return dao.findD();
	}

	public List<Material> findM() {
		// TODO Auto-generated method stub
		return dao.findM();
	}

	public List<Value> findV() {
		// TODO Auto-generated method stub
		return dao.findV();
	}

	public List<Exhibits> findBy(String str, String str1, String str2,
			String str3, String str4) {
		 
		return dao.findBy(str, str1, str2, str3,str4);
	}

	public List<Hall> findH() {
		// TODO Auto-generated method stub
		return dao.findH();
	}

	public List<Nation> findN() {
		// TODO Auto-generated method stub
		return dao.findN();
	}

	public List<Religion> findR() {
		// TODO Auto-generated method stub
		return dao.findR();
	}

	public List<State> findS() {
		// TODO Auto-generated method stub
		return dao.findS();
	}

	public Apply finda(Integer aId) {
		// TODO Auto-generated method stub
		return dao.finda(aId);
	}

	public Dynasty findd(Integer dId) {
		// TODO Auto-generated method stub
		return dao.findd(dId);
	}

	public Hall findh(Integer hId) {
		// TODO Auto-generated method stub
		return dao.findh(hId);
	}

	public Nation findn(Integer nId) {
		// TODO Auto-generated method stub
		return dao.findn(nId);
	}

	public Religion findr(Integer rId) {
		// TODO Auto-generated method stub
		return dao.findr(rId);
	}

	public State finds(Integer sId) {
		// TODO Auto-generated method stub
		return dao.finds(sId);
	}

	public Value findv(Integer vId) {
		// TODO Auto-generated method stub
		return dao.findv(vId);
	}

	public Material finm(Integer mId) {
		// TODO Auto-generated method stub
		return dao.finm(mId);
	}

	public void updateC(Integer exhibitsId) {
		// TODO Auto-generated method stub
		dao.updateC(exhibitsId);
	}

	public void updateR(Integer exhibitsId) {
		// TODO Auto-generated method stub
		dao.updateR(exhibitsId);
	}





}
