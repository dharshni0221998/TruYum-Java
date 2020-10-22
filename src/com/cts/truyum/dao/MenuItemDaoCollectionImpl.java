package com.cts.truyum.dao;

import java.util.List;

import com.cts.truyum.model.MenuItem;

public class MenuItemDaoCollectionImpl implements MenuItemDao{
	private List<MenuItem> menuItemList;
	
	public MenuItemDaoCollectionImpl(){
		
	}
	public List<MenuItem> getMenuItemListAdmin(){
		return menuItemList;
		
	}
	public List<MenuItem> getMenuItemListCustomer(){
		return menuItemList;
		
	}
	public void modifyMenuItem(MenuItem menuItem){
		
	}
	public MenuItem getMenuItem(long menuItemId){
		return null;
		
	}

}
