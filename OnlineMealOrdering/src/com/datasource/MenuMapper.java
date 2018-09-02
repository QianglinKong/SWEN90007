package com.datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.domian.Menu;

public class MenuMapper {
	
	//save the menu to database
	public static boolean saveMenu(Menu menu) {
		String sql = "INSERT INTO menu (resturant_name, manager_id) VALUES (?,?)";
		int result = 0;
		try {
			PreparedStatement sqlPrepared = DBConnection.prepare(sql);
			sqlPrepared.setString(1, menu.getResturantName());
			sqlPrepared.setString(2, menu.getManagerId());
			result = sqlPrepared.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result==0) {
			return false;
		}else {
			return true;
		}
	}
	
	public static Menu findMenuByManagerId(String managerId) throws SQLException {
		String sql = "SELECT menu_id, resturant_name, manager_id FROM menu" + " WHERE manager_id = ?";
		ResultSet rs;
		int menuId = -1;
		int ownerId = -1;
		String resturantName = "";
		PreparedStatement sqlPrepared = DBConnection.prepare(sql);
		sqlPrepared.setString(1, managerId);
		rs = sqlPrepared.executeQuery();
		while(rs.next()) {
			menuId = rs.getInt(1);
			resturantName = rs.getString(2);
			ownerId = rs.getInt(3);
		}
//		System.out.println(new Menu(String.valueOf(mid),resturantName).getMenuId());
		return new Menu(String.valueOf(menuId),resturantName,String.valueOf(ownerId));
		
	}

}
