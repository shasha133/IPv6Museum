package com.dao;

import java.util.List;

import com.museum.domain.Activity;
import com.museum.domain.Apply;
import com.museum.domain.Dynasty;
import com.museum.domain.Exhibits;
import com.museum.domain.Hall;
import com.museum.domain.Material;
import com.museum.domain.Nation;
import com.museum.domain.News;
import com.museum.domain.Religion;
import com.museum.domain.State;
import com.museum.domain.Value;



public interface IExhibitsDao1 {
	public void save(Exhibits exhibits);
	public void delete(Integer exhibitsId);
	public void update(Exhibits exhibits);
	public List<Exhibits> find();
	public Exhibits find(Integer exhibitsId);
	public void updateC(Integer exhibitsId);
	public void updateR(Integer exhibitsId);
	
	public List<State> findS();
	public List<Religion> findR();
	public List<Nation> findN();
	public List<Hall> findH();
	
	public List<Material> findM();
	public List<Dynasty> findD();
	public List<Apply> findA();
	public List<Value> findV();
	
	public State finds(Integer sId);
	public Religion findr(Integer rId);
	public Nation findn(Integer nId);
	public Hall findh(Integer hId);
	public Material finm(Integer mId);
	public Dynasty findd(Integer dId);
	public Apply finda(Integer aId);
	public Value findv(Integer vId);
	
	
	public List<Exhibits> findBy(String str,String str1,String str2,String str3,String str4);
	public int getRowCount();
	public List<Exhibits> find(int StratLine,int size);
}
