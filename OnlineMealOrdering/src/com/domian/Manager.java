package com.domian;

import java.sql.SQLException;

import com.datasource.ManagerMapper;
import com.datasource.MenuMapper;

public class Manager {
	private String name;
	private String managerId;
	
	public Manager(String id, String name){
		this.managerId = id;
		this.name = name;
	}
	public static Manager login(String username, String pwd) {
		Manager manager = null;
		try {
			manager = ManagerMapper.findWithusernamePwd(username, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manager;
	}
	public void createMenu(Menu menu) {
		menu.setManagerId(this.managerId);
		MenuMapper.saveMenu(menu);
	}
	
	public Menu getMenu() throws SQLException {
		return MenuMapper.findMenuByManagerId(this.managerId);
	}
	public void deleteMenu(String menuId) {}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	
	

}
