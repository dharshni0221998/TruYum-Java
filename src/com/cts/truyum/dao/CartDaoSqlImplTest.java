package com.cts.truyum.dao;

import java.util.List;

import com.cts.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Insert into Cart");
		testAddCartItem();
		System.out.println("Get Menu Item");
		testGetAllCartItems();
		System.out.println("Delete cart record");
		testRemoveCartItem();

	}
	public static void testAddCartItem(){
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.addCartItem(1, 3);
	}

	public static void testGetAllCartItems(){
		CartDao cartDao = new CartDaoSqlImpl();
		try {
			List<MenuItem> menuItemList = cartDao.getAllCartItems(1);
			for(MenuItem m:menuItemList){
				System.out.println(m);
			}
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void testRemoveCartItem(){
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.removeCartItem(1, 3);
	}
}
