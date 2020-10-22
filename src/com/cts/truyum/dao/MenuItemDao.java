package com.cts.truyum.dao;

import java.util.List;

import com.cts.truyum.model.MenuItem;

public interface MenuItemDao {
	
	public List<MenuItem> getMenuItemListAdmin();
	public List<MenuItem> getMenuItemListCustomer();
	public void modifyMenuItem(MenuItem menuItem);
	public MenuItem getMenuItem(long menuItemId);

}
