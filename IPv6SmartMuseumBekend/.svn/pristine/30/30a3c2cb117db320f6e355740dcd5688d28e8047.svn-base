package com.IPv6Museum.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.IPv6Museum.model.Cell;

public class CellDao {
	private ConnectMysql connectMysql=new ConnectMysql();
	private Connection connection=connectMysql.getConn();
	public List<Cell> ListCell() {
		List<Cell> listRes=new ArrayList<>();
		String sql="select * from cell";
		try {
			Statement stmt=connection.createStatement();
			ResultSet rst=stmt.executeQuery(sql);
			while (rst.next()) {
				Cell cell=new Cell();
				cell.setCell_id(rst.getInt(1));
				cell.setCell_x1(rst.getString(2));
				cell.setCell_x2(rst.getString(4));
				cell.setCell_x3(rst.getString(6));
				cell.setCell_x4(rst.getString(8));
				cell.setCell_y1(rst.getString(3));
				cell.setCell_y2(rst.getString(5));
				cell.setCell_y3(rst.getString(7));
				cell.setCell_y4(rst.getString(9));
				cell.setExhibits_id(rst.getInt(10));
				listRes.add(cell);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listRes;
	}

}
