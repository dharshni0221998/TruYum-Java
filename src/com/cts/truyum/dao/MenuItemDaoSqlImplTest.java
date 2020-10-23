package com.cts.truyum.dao;

import java.util.List;

import com.cts.truyum.model.MenuItem;
import com.cts.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Menu Item Admin List");
		testGetMenuItemListAdmin();
		System.out.println("Customer Menu List");
		testGetMenuItemListCustomer();
		System.out.println("Menu Item");
		testGetMenuItem();
		System.out.println("Update Menu List");
		testModifyMenuItem();

	}
	
	public static void testGetMenuItemListAdmin(){
		MenuItemDao menuItem = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItem.getMenuItemListAdmin();
		for(MenuItem m:menuItemList){
			System.out.println(m);
		}
	}
	public static void testGetMenuItemListCustomer(){
		MenuItemDao menuItem = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItem.getMenuItemListCustomer();
		for(MenuItem m:menuItemList){
			System.out.println(m);
		}
	}
	public static void testGetMenuItem(){
		MenuItemDao menuItem = new MenuItemDaoSqlImpl();
		MenuItem menuItemObj = menuItem.getMenuItem(2);
		System.out.println(menuItemObj);
	}
	public static void testModifyMenuItem(){
		MenuItemDao menuItem = new MenuItemDaoSqlImpl();
		MenuItem menuItemObj = new MenuItem(2,"Veg burger",110.00f,true,DateUtil.convertToDate("18/08/2017"),"Main Course",true);
		menuItem.modifyMenuItem(menuItemObj);
	}

}
