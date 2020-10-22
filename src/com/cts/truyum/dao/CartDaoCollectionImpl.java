package com.cts.truyum.dao;

import java.util.HashMap;
import java.util.List;

import com.cts.truyum.model.Cart;
import com.cts.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao{
	@SuppressWarnings("unused")
	private HashMap<Long,Cart> userCarts;
	
	public CartDaoCollectionImpl(){
		
	}
	public void addCartItem(long userId,long menuItemId){
		
	}
	public List<MenuItem> getAllCartItems(long userId){
		return null;
		
	}
	public void removeCartItem(long userId,long menuItemId){
		
	}
}
