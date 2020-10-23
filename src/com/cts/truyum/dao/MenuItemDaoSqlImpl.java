package com.cts.truyum.dao;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.cts.truyum.model.MenuItem;
import com.cts.truyum.util.ConnectionHandler;

public  class MenuItemDaoSqlImpl implements MenuItemDao{
	public static PreparedStatement ps=null;
	public SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd"); 
	public SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy"); 
	
	public List<MenuItem> getMenuItemListAdmin(){
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		String str = "select * from menu_item";
		try {
			ps=ConnectionHandler.getConnection().prepareStatement(str);
			ResultSet rs =ps.executeQuery();
			ps.clearParameters();
			while(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				float price=rs.getFloat(3);
				boolean active = rs.getString(4).equalsIgnoreCase("yes")?true:false;
				Date dateOfLaunch=null;
				try {
				 dateOfLaunch =  format1.parse(format1.format(rs.getDate(5)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String category =rs.getString(6);
				boolean freeDel = rs.getString(7).equalsIgnoreCase("yes")?true:false;
				menuItemList.add(new MenuItem(id,name,price,active,dateOfLaunch,category,freeDel));
				
			}
			return menuItemList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public MenuItem getMenuItem(long menuItemId){
		MenuItem menuItem =null;
		String str = "select * from menu_item where menu_id=?";
		try {
			ps=ConnectionHandler.getConnection().prepareStatement(str);
			ps.setInt(1, (int) menuItemId);
			ResultSet rs =ps.executeQuery();
			ps.clearParameters();
			if(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				float price=rs.getFloat(3);
				boolean active = rs.getString(4).equalsIgnoreCase("yes")?true:false;
				Date dateOfLaunch=null;
				try {
				 dateOfLaunch =  format1.parse(format1.format(rs.getDate(5)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String category =rs.getString(6);
				boolean freeDel = rs.getString(7).equalsIgnoreCase("yes")?true:false;
				menuItem=new MenuItem(id,name,price,active,dateOfLaunch,category,freeDel);
				return menuItem;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		String str = "select * from menu_item where menu_active=? and menu_date_of_launch between menu_date_of_launch and now()";
		try {
			ps=ConnectionHandler.getConnection().prepareStatement(str);
			ps.setString(1, "yes");
			ResultSet rs =ps.executeQuery();
			ps.clearParameters();
			while(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				float price=rs.getFloat(3);
				boolean active = rs.getString(4).equalsIgnoreCase("yes")?true:false;
				Date dateOfLaunch=null;
				try {
				 dateOfLaunch =  format1.parse(format1.format(rs.getDate(5)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String category =rs.getString(6);
				boolean freeDel = rs.getString(7).equalsIgnoreCase("yes")?true:false;
				menuItemList.add(new MenuItem(id,name,price,active,dateOfLaunch,category,freeDel));
				
			}
			return menuItemList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		String str = "update menu_item set menu_name=?,menu_price=?,menu_active=?,menu_date_of_launch=?,menu_category=?,menu_free_delivery=? where menu_id=?";
		
		try {
			ps=ConnectionHandler.getConnection().prepareStatement(str);
			ps.setString(1,menuItem.getName());
			ps.setFloat(2, menuItem.getPrice());
			ps.setString(3,menuItem.isActive()?"yes":"no");
			try {
				java.sql.Date dateOfLauch = new java.sql.Date(format.parse(format.format(menuItem.getDateOfLaunch())).getTime());
				ps.setDate(4,dateOfLauch);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ps.setString(5, menuItem.getCategory());
			ps.setString(6, menuItem.isFreeDelivery()?"yes":"no");
			ps.setInt(7, (int) menuItem.getId());
			if(ps.executeUpdate()>0){
				System.out.println("Updated Sucessfully");
			}
			ps.clearParameters();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
