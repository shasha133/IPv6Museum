package com.IPv6Museum.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.IPv6Museum.model.Feature;

public class FeatureDao {
	
	private ConnectMysql connectMysql=new ConnectMysql();
	private Connection connection=connectMysql.getConn();
	
	/*
	 * 按年代查询
	 * 升序，返回年代最早的10个展品信息
	 * feature_years，feature_value，Feature_id，exhibits_id
	 */
	public List<Feature> getFeatureByYear(){
		
		List<Feature> list=new ArrayList<>();
		String sql=" select * from feature order by feature_years asc limit 10 ";
		
		try {
			Statement stmt=connection.createStatement();
			ResultSet rst=stmt.executeQuery(sql);
			
			while (rst.next()) {
				Feature feature=new Feature();
				feature.setFeature_years(rst.getInt(1));
				feature.setFeature_value(rst.getInt(2));
				feature.setClassification_id(rst.getInt(3));
				feature.setExhibits_id(rst.getString(4));
				list.add(feature);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * 按价值查询
	 * 降序，返回价值最高的前10个展品信息
	 * feature_years，feature_value，Feature_id，exhibits_id
	 */
	public List<Feature> getFeatureByValue(){
		
		List<Feature> list=new ArrayList<>();
		String sql=" select * from feature order by feature_value desc limit 10";
		
		try {
			Statement stmt=connection.createStatement();
			ResultSet rst=stmt.executeQuery(sql);
			
			while (rst.next()) {
				Feature feature=new Feature();
				feature.setFeature_years(rst.getInt(1));
				feature.setFeature_value(rst.getInt(2));
				feature.setClassification_id(rst.getInt(3));
				feature.setExhibits_id(rst.getString(4));
				list.add(feature);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * 查询所有的青铜器
	 * feature_years，feature_value，Feature_id，exhibits_id
	 */
	public List<Feature> getFeatureOfBronzeware(){
		
		List<Feature> list=new ArrayList<>();
		String sql="select * from feature where classification_id=3";
		
		try {
			Statement stmt=connection.createStatement();
			ResultSet rst=stmt.executeQuery(sql);
			
			while (rst.next()) {
				Feature feature=new Feature();
				feature.setFeature_years(rst.getInt(1));
				feature.setFeature_value(rst.getInt(2));
				feature.setClassification_id(rst.getInt(3));
				feature.setExhibits_id(rst.getString(4));
				list.add(feature);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * 查询所有的瓷器
	 * feature_years，feature_value，Feature_id，exhibits_id
	 */
	public List<Feature> getFeatureOfChinaware(){
		
		List<Feature> list=new ArrayList<>();
		String sql="select * from feature where classification_id=4";
		
		try {
			Statement stmt=connection.createStatement();
			ResultSet rst=stmt.executeQuery(sql);
			
			while (rst.next()) {
				Feature feature=new Feature();
				feature.setFeature_years(rst.getInt(1));
				feature.setFeature_value(rst.getInt(2));
				feature.setClassification_id(rst.getInt(3));
				feature.setExhibits_id(rst.getString(4));
				list.add(feature);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * 查询所有的玉器
	 * feature_years，feature_value，Feature_id，exhibits_id
	 */
	public List<Feature> getFeatureOfJadeware(){
		
		List<Feature> list=new ArrayList<>();
		String sql="select * from feature where classification_id=5";
		
		try {
			Statement stmt=connection.createStatement();
			ResultSet rst=stmt.executeQuery(sql);
			
			while (rst.next()) {
				Feature feature=new Feature();
				feature.setFeature_years(rst.getInt(1));
				feature.setFeature_value(rst.getInt(2));
				feature.setClassification_id(rst.getInt(3));
				feature.setExhibits_id(rst.getString(4));
				list.add(feature);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
