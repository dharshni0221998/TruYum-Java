package com.cts.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.cts.truyum.model.MenuItem;
import com.cts.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao{
	private static List<MenuItem> menuItemList;
	
	public MenuItemDaoCollectionImpl(){
		if(menuItemList==null){
			menuItemList = new ArrayList<MenuItem>();
			MenuItem[] me =new MenuItem[5];
			me[0]=new MenuItem(100,"Sandwich",99.00f,true,DateUtil.convertToDate("15/03/2017"),"Main Course",true);
			me[1]=new MenuItem(101,"Burger",129.00f,true,DateUtil.convertToDate("23/12/2017"),"Main Course",false);
			me[2]=new MenuItem(102,"Pizza",149.00f,true,DateUtil.convertToDate("21/08/2018"),"Main Course",false);
			me[3]=new MenuItem(103,"French Fries",57.00f,false,DateUtil.convertToDate("02/07/2017"),"Starter",true);
			me[4]=new MenuItem(104,"Chocolate Browine",32.00f,true,DateUtil.convertToDate("02/11/2022"),"Dessert",true);
			for(MenuItem e:me){
				menuItemList.add(e);
			}

		}
		
	}
	public List<MenuItem> getMenuItemListAdmin(){
		return menuItemList;
		
	}
	public List<MenuItem> getMenuItemListCustomer(){
		List<MenuItem> menuItemList1 = new ArrayList<MenuItem>();
		menuItemList1=menuItemList.stream().filter(e->{
			boolean flag=(e.getDateOfLaunch().before(new Date())||e.getDateOfLaunch().compareTo(new Date())==0)&&(e.isActive());
			return flag;
		}).collect(Collectors.toList());
		
		return menuItemList1;
		
	}
	public void modifyMenuItem(MenuItem menuItem){
		for(MenuItem e: menuItemList){
			if(e.equals(menuItem)){
				e.setActive(menuItem.isActive());
				e.setCategory(menuItem.getCategory());
				e.setDateOfLaunch(menuItem.getDateOfLaunch());
				e.setFreeDelivery(menuItem.isFreeDelivery());
				e.setId(menuItem.getId());
				e.setName(menuItem.getName());
				e.setPrice(menuItem.getPrice());
			}
		}
		
	}
	public MenuItem getMenuItem(long menuItemId){
		for(MenuItem e:menuItemList){
			if(e.getId()==menuItemId){
				return e;
			}
		}
		return null;
		
	}

}
