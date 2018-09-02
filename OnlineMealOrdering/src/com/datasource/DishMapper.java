package com.datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.domian.Dish;

public class DishMapper {
	
	//get all dish related to a given menu
	public static ArrayList<Dish> getDishesByMenuId(String mid) throws SQLException {
		ArrayList<Dish> result = new ArrayList<Dish>();
		String sql = "SELECT dish_id, name, price, picture, decription FROM dish" + " WHERE menu_id = ?";
		ResultSet rs;
		int dishId = -1;
		String name = "";
		float price = 0f;
		String filePath = "";
		String description = "";

		PreparedStatement sqlPrepared = DBConnection.prepare(sql);
		sqlPrepared.setString(1, mid);
		rs = sqlPrepared.executeQuery();
		while (rs.next()) {
			dishId = rs.getInt(1);
			name = rs.getString(2);
			price = rs.getFloat(3);
			filePath = rs.getString(4);
			description = rs.getString(5);
			Dish dish = new Dish(String.valueOf(dishId), price, name, description,filePath);
			result.add(dish);
		}
		return result;
	}
	
	public static boolean saveDish(Dish dish) {
		String sql = "INSERT INTO dish (menu_id, price, name, description, picture) VALUES (?,?,?,?,?)";
		int result = 0;
		try {
			PreparedStatement sqlPrepared = DBConnection.prepare(sql);
			sqlPrepared.setInt(1, Integer.parseInt(dish.getMenuId()));
			sqlPrepared.setFloat(2, dish.getPrice());
			sqlPrepared.setString(3, dish.getDishName());
			sqlPrepared.setString(4, dish.getDescription());
			sqlPrepared.setString(5, dish.getFilePath());
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

}
