package com.IPv6Museum.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.IPv6Museum.model.Exhibits;

/**
 * 查找展品信息
 * exhibits_id， exhibits_name， exhibits_img（缩略图）
 * @author tian
 *
 */
public class ExhibitsDao {
	
	private ConnectMysql connectMysql=new ConnectMysql();
	private Connection connection=connectMysql.getConn();
	
	//查找全部展品信息
	public List<Exhibits> ListExhibits() {
		
		List<Exhibits> list=new ArrayList<>();
		String sql="select * from exhibits";
		
		try {
			Statement stmt=connection.createStatement();
			ResultSet rst=stmt.executeQuery(sql);
			while (rst.next()) {
				
				Exhibits exhibits=new Exhibits();
				exhibits.setExhibits_id(rst.getString(1));
				exhibits.setExhibits_name(rst.getString(2));
				exhibits.setExhibits_img(rst.getString(3));
				
				list.add(exhibits);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;		
	}

	//根据编号找展品信息
	public List<Exhibits> GetExhibitsByExhibits_id(int id) {
		
		List<Exhibits> list=new ArrayList<>();
		String sql="select * from exhibits where exhibits_id="+id;
		try {
			
			Statement stmt=connection.createStatement();
			ResultSet rst=stmt.executeQuery(sql);
			
			while (rst.next()) {
				Exhibits exhibits=new Exhibits();
				exhibits.setExhibits_id(rst.getString(1));
				exhibits.setExhibits_name(rst.getString(2));
				exhibits.setExhibits_img(rst.getString(3));
		
				list.add(exhibits);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;		
	}
}
