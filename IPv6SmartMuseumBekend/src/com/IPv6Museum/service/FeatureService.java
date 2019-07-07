package com.IPv6Museum.service;

import java.util.ArrayList;
import java.util.List;

import com.IPv6Museum.dao.FeatureDao;
import com.IPv6Museum.model.Feature;

/**
 * 根据指定条件进行查询
 * 返回：符合条件的展品编号集
 * @author tian
 *
 */
public class FeatureService {
	
	private FeatureDao featureDao = new FeatureDao();
	
	//返回年代最早的展品的编号集
	public List<String> getByYears(){
		
		List<String> idList = new ArrayList<String>();
		
		List<Feature> year = featureDao.getFeatureByYear();
		
		for(int i = 0; i < year.size(); i++){
			idList.add(year.get(i).getExhibits_id());
		}
		
		return idList;
	}
	
	//返回价值最高的展品的编号集
	public List<String> getByValue(){
		
		List<String> idList = new ArrayList<String>();
		
		List<Feature> value = featureDao.getFeatureByValue();
		
		for(int i = 0; i < value.size(); i++){
			idList.add(value.get(i).getExhibits_id());
		}
		
		return idList;
	}

	//返回青铜器类展品的编号集
	public List<String> getBronzeware(){
		
		List<String> idList = new ArrayList<String>();
		
		List<Feature> bronzeware = featureDao.getFeatureOfBronzeware();
		
		for(int i = 0; i < bronzeware.size(); i++){
			idList.add(bronzeware.get(i).getExhibits_id());
		}
		
		return idList;
	}
	
	//返回瓷器类展品的编号集
	public List<String> getChinaware(){
		
		List<String> idList = new ArrayList<String>();
		
		List<Feature> chinaware = featureDao.getFeatureOfChinaware();
		
		for(int i = 0; i < chinaware.size(); i++){
			idList.add(chinaware.get(i).getExhibits_id());
		}
		
		return idList;
	}
	
	//返回玉器类展品的编号集
	public List<String> getJadeware(){
		
		List<String> idList = new ArrayList<String>();
		
		List<Feature> jadeware = featureDao.getFeatureOfJadeware();
		
		for(int i = 0; i < jadeware.size(); i++){
			idList.add(jadeware.get(i).getExhibits_id());
		}
		
		return idList;
	}
}
