package com.IPv6Museum.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMysql {
	
	private Connection connection=null;
	
	public ConnectMysql() {
		if (connection==null) {
			Conn();
		} else {
			System.out.println("数据库已连接！！");

		}
	}
	private void Conn() {
		String user="root";
		String password="123456";
		String url="jdbc:mysql://localhost/museum";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(url, user, password);
			if (connection!=null) {
				System.out.println("数据库连接成功");
			}
		} catch (ClassNotFoundException e) {
			System.err.println("驱动加载失败");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("数据库加载失败");
			e.printStackTrace();
		}
		
	}
	public Connection getConn() {
		return connection;
	}

}
