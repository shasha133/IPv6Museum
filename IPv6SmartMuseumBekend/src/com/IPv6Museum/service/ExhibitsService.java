package com.IPv6Museum.service;

import java.util.List;

import com.IPv6Museum.dao.ExhibitsDao;
import com.IPv6Museum.dao.ExhibitsinfoDao;
import com.IPv6Museum.model.Exhibits;
import com.IPv6Museum.model.Exhibitsinfo;

/**
 * 根据展品编号查询展品信息
 * @author tian
 *
 */
public class ExhibitsService {
	
	private ExhibitsinfoDao exhibitsinfoDao = new ExhibitsinfoDao();
	private ExhibitsDao exhibitsDao = new ExhibitsDao();
	
	/*
	 * 根据展品标号查询相应的展品的详细信息
	 */
	public List<Exhibitsinfo> getExhibitsinfos(int exhibits_id){
		
		List<Exhibitsinfo> list = exhibitsinfoDao.GetExhibitsinfoByExhibits_id(exhibits_id);
		
		return list;
	}
	
	/*
	 * 根据展品标号查询相应的展品的信息,exhibits_id， exhibits_name， exhibits_img（缩略图）
	 */
	public List<Exhibits> getExhibits(int exhibits_id){
		
		List<Exhibits> list = exhibitsDao.GetExhibitsByExhibits_id(exhibits_id);
		
		return list;
	}
	
}
