package com.cts.truyum.dao;

import java.util.List;
import java.util.Scanner;

import com.cts.truyum.model.MenuItem;
import com.cts.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Item List Admin");
		testGetMenuItemListAdmin();
		System.out.println("Menu Item List Customer");
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		System.out.println("Modified Menu Item List");
		System.out.println("Enter Product Id");
		long productId =Long.parseLong(sc.nextLine());
		testGetMenuItem(productId);
		
		sc.close();

	}
	public static void testGetMenuItemListAdmin(){
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList=menuItemDao.getMenuItemListAdmin();
		for(MenuItem o: menuItemList){
			System.out.println(o);
		}
	}
	public static void testGetMenuItemListCustomer(){
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem>menuItemList=menuItemDao.getMenuItemListCustomer();
		for(MenuItem e:menuItemList){
			System.out.println(e);
		}
	}
	public static void testModifyMenuItem(){
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(new MenuItem(100,"Sandwich",69.00f,true,DateUtil.convertToDate("15/03/2017"),"Main Course",false));
	}
	public static void testGetMenuItem(long productId){
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		System.out.println(menuItemDao.getMenuItem(productId));
	}

}
