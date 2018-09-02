package com.domian;

import java.util.ArrayList;

import com.datasource.MenuMapper;

public class Menu {
	private String menuId;
	private String managerId;
	private ArrayList<Dish> dish;
	private String resturantName;
	
	/**
	 * used when new dish is created
	 * @param menuId
	 * @param resturantName
	 * @param ownerId
	 */
	public Menu(String menuId, String resturantName,String ownerId){
		this.menuId = menuId;
		this.resturantName = resturantName;
		this.managerId = ownerId;
	}
	
	/**
	 * Used when manager create a menu
	 * @param managerId
	 * @param resturantName
	 */
	public Menu(String managerId, String resturantName) {
		this.managerId = managerId;
		this.resturantName = resturantName;
	}
	
	public Menu(String managerId,ArrayList<Dish> dish, String resturantName){
		this.managerId = managerId;
		this.dish = dish;
		this.resturantName = resturantName;
	}
	
	public static boolean createMenu(String resturantName, String managerId) {
		Menu menu = new Menu(managerId, resturantName);
		return MenuMapper.saveMenu(menu);
	}
	
	/**
	 * @return all the dishes that belong to the menu
	 */
	public ArrayList<Dish> getAllDishes() {
		
		return new ArrayList();
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public ArrayList<Dish> getDish() {
		return dish;
	}

	public void setDish(ArrayList<Dish> dish) {
		this.dish = dish;
	}

	public String getResturantName() {
		return resturantName;
	}

	public void setResturantName(String resturantName) {
		this.resturantName = resturantName;
	}
	
	
	
	

}
