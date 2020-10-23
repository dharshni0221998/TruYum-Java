package com.cts.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.cts.truyum.model.Cart;
import com.cts.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao{
	private static HashMap<Long,Cart> userCarts;
	
	public CartDaoCollectionImpl(){
		if(userCarts==null){
			userCarts = new HashMap<Long,Cart>();
			/*List<MenuItem> menuItemList = new ArrayList<MenuItem>();
			MenuItemDaoCollectionImpl meItem = new MenuItemDaoCollectionImpl();
			menuItemList.add(meItem.getMenuItem(100));
			menuItemList.add(meItem.getMenuItem(102));
			Double total = menuItemList.stream().mapToDouble(e->e.getPrice()).sum();
			userCarts.put((long) 1001, new Cart(menuItemList,total));
			menuItemList.add(meItem.getMenuItem(103));
			total = menuItemList.stream().mapToDouble(e->e.getPrice()).sum();
			userCarts.put((long) 1002, new Cart(menuItemList,total));*/
			
		}
		
	}
	public void addCartItem(long userId,long menuItemId){
		
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		boolean set =false;
		if(!userCarts.isEmpty()){
		for(Entry<Long, Cart> e:userCarts.entrySet()){
			if(e.getKey()==userId){
				e.getValue().getMenuItemList().add(menuItem);
				set = true;
				break;
			}
			
		}
		}
		if(!set){
			List<MenuItem> menuItemList = new ArrayList<MenuItem>();
			//double total;
			menuItemList.add(menuItem);
			//total=menuItem.getPrice();
			userCarts.put(userId, new Cart(menuItemList,0));
		}
		
		
	}
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException{
		List<MenuItem> menuListItem=new ArrayList<MenuItem>();
		for(Entry<Long,Cart> e: userCarts.entrySet()){
			if(e.getKey()==userId){
				if(e.getValue().getMenuItemList().isEmpty()){
					throw new CartEmptyException();
				}
				else{
					double total=0;
					menuListItem = e.getValue().getMenuItemList();
					for(MenuItem m:menuListItem){
						total+=m.getPrice();
					}
					e.getValue().setTotal(total);
					//System.out.println(e.getValue().getTotal());
				}
				return e.getValue().getMenuItemList();
			}
		}
		return null;
		
	}
	public void removeCartItem(long userId,long menuItemId){
		
		List<MenuItem> menuListItem=new ArrayList<MenuItem>();
		for(Entry<Long,Cart>e:userCarts.entrySet()){
			if(e.getKey()==userId){
				menuListItem = e.getValue().getMenuItemList();
				for(int i=0;i<menuListItem.size();i++){
					if(menuListItem.get(i).getId()==menuItemId){
						menuListItem.remove(i);
					}
				}
				
			}
		}
		
		
		
	}
}
