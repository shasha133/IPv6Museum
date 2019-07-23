package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.IExhibitsDao1;
import com.museum.domain.Activity;
import com.museum.domain.Apply;
import com.museum.domain.Comment;
import com.museum.domain.Dynasty;
import com.museum.domain.Exhibits;
import com.museum.domain.Hall;
import com.museum.domain.Material;
import com.museum.domain.Nation;
import com.museum.domain.Religion;
import com.museum.domain.State;
import com.museum.domain.User;
import com.museum.domain.Value;



@Repository
public class ExhibitsDaoImpl1 implements IExhibitsDao1 {
	@Autowired
	private SessionFactory sf;
	
	private Session getSession(){
		return  sf.getCurrentSession();
		
	}
	public void delete(Integer exhibitsId) {
		Exhibits exhibits=(Exhibits) getSession().get(Exhibits.class,exhibitsId);
		getSession().delete(exhibits);
	}

	public List<Exhibits> find() {

		return getSession().createQuery("FROM Exhibits").list();
	}

	public Exhibits find(Integer exhibitsId) {
		return (Exhibits) getSession().get(Exhibits.class,exhibitsId);
	}



	public List<Exhibits> findBy(String str, String str1, String str2,String str3,String str4
			) {
		  String hql = "from Exhibits where (Material_id=?  and Dynasty_id=? and Apply_id=?   and  Value_id=? )or Exhibits_name=?";  
		  Query query = getSession().createQuery(hql);
		  query.setString(0, str);  
		  query.setString(1, str1);  
		  query.setString(2, str2);  
		  query.setString(3, str3);  
		  query.setString(4, str4);
		  List<Exhibits> list = query.list(); 
		  return list;  
	}


	public void save(Exhibits exhibits) {
		getSession().save(exhibits);
	}

	public void update(Exhibits exhibits) {
		getSession().update(exhibits);
	}
	public List<Exhibits> find(int StratLine, int size) { 
		Query q= getSession().createQuery("FROM Exhibits");
		q.setFirstResult(StratLine);
		q.setMaxResults(size);
		return q.list();
	}
	public int getRowCount() { 
		long x=(Long) getSession().createQuery("SELECT COUNT(*) FROM Exhibits").uniqueResult();
		return (int) x;
	}
	public List<Apply> findA() {
		return getSession().createQuery("FROM Apply").list();
	}
	public List<Dynasty> findD() { 
		return getSession().createQuery("FROM Dynasty").list();
	}
	public List<Material> findM() { 
		return getSession().createQuery("FROM Material").list();
	}
	public List<Value> findV() { 
		return getSession().createQuery("FROM Value").list();
	}
	public List<Hall> findH() {
		// TODO Auto-generated method stub
		return getSession().createQuery("FROM Hall").list()
		;
	}
	public List<Nation> findN() {
		// TODO Auto-generated method stub
		return getSession().createQuery("FROM Nation").list();
	}
	public List<Religion> findR() {
		// TODO Auto-generated method stub
		return getSession().createQuery("FROM Religion").list();
	}
	public List<State> findS() {
		// TODO Auto-generated method stub
		return getSession().createQuery("FROM State").list();
	}
	public Apply finda(Integer aId) {
		// TODO Auto-generated method stub
		return (Apply) getSession().get(Apply.class,aId);
	}
	public Dynasty findd(Integer dId) { 
		return (Dynasty) getSession().get(Dynasty.class,dId);
	}
	public Hall findh(Integer hId) {
		// TODO Auto-generated method stub

		return (Hall) getSession().get(Hall.class,hId);
	}
	public Nation findn(Integer nId) {

		return (Nation) getSession().get(Nation.class,nId);
	}
	public Religion findr(Integer rId) {
		// TODO Auto-generated method stub
		return (Religion) getSession().get(Religion.class,rId);
	}
	public State finds(Integer sId) {
		// TODO Auto-generated method stub

		return (State) getSession().get(State.class,sId);
	}
	public Value findv(Integer vId) {
		// TODO Auto-generated method stub

		return (Value) getSession().get(Value.class,vId);
	}
	public Material finm(Integer mId) {

		return (Material) getSession().get(Material.class,mId);
	}
	public void updateC(Integer exhibitsId) {
		  String hql = "update Exhibits set Exhibits_cherish=Exhibits_cherish-1 where Exhibits_id=?";  
		  Query query = getSession().createQuery(hql);
		  query.setInteger(0, exhibitsId); 
		  query.executeUpdate();

	}
	public void updateR(Integer exhibitsId) {
		  String hql = "update Exhibits set Exhibits_browse=Exhibits_browse-1 where Exhibits_id=?";  
		  Query query = getSession().createQuery(hql);
		  query.setInteger(0, exhibitsId); 
		  query.executeUpdate();
	}

}
