package com.domian;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.datasource.DBConnection;
import com.datasource.DishMapper;
import com.datasource.MenuMapper;

public class Dish {
	private String dishId;
	private float price;
	private String dishName;
	private String filePath;
	private String description;
	private String menuId;
	
	Dish(){}
	
	public Dish(String dishId, float price, String dishName, String description,String filePath){
		this.price = price;
		this.dishName = dishName;
		this.filePath = filePath;
		this.description = description;
	}
	
	public static boolean createDish(String dishName, String price, String description, 
			String filePath,String managerId) {
		Dish dish = new Dish();
		dish.setDishName(dishName);
		dish.setPrice(Float.valueOf(price));
		dish.setDescription(description);
		dish.setFilePath(filePath);
		Menu menu = null;
		try {
			menu = MenuMapper.findMenuByManagerId(managerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dish.setMenuId(menu.getMenuId());
		return DishMapper.saveDish(dish);
	}

	public String getDishId() {
		return dishId;
	}

	public void setDishId(String dishId) {
		this.dishId = dishId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	
	

}
