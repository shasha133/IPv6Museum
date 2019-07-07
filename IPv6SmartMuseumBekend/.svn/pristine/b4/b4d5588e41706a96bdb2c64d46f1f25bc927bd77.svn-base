package com.IPv6Museum.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.IPv6Museum.model.News;

public class NewsDao {

	private ConnectMysql connectMysql=new ConnectMysql();
	private Connection connection=connectMysql.getConn();
	
	public List<News> ListNews() {
		
		List<News> list=new ArrayList<>();
		String sql="select * from news";
		
		try {
			Statement stmt=connection.createStatement();
			ResultSet rst=stmt.executeQuery(sql);
			while (rst.next()) {
				News news=new News();
				news.setNews_id(rst.getInt(1));
				news.setNews_title(rst.getString(2));
				news.setNews_abstract(rst.getString(3));
				news.setNews_imgpath(rst.getString(4));
				news.setNews_time(rst.getDate(5));
				news.setNews_context(rst.getString(6));
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

	public News GetNewsByNews_id(int id) {
		String sql="select * from news where news_id="+id;
		News news=new News();
		try {
			
			Statement stmt=connection.createStatement();
			ResultSet rst=stmt.executeQuery(sql);
							
			while (rst.next()) {
				news.setNews_id(rst.getInt(1));
				news.setNews_title(rst.getString(2));
				news.setNews_abstract(rst.getString(3));
				news.setNews_imgpath(rst.getString(4));
				news.setNews_time(rst.getDate(5));
				news.setNews_context(rst.getString(6));
			}				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return news;		
	}

}
