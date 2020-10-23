package com.cts.truyum.dao;

import java.util.List;

import com.cts.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testAddCartItem();
		System.out.println("Added Items in cart");
		testGetAllCartItems();
		System.out.println("Remove Cart Item");
		testRemoveCartItem();

	}
	public static void testAddCartItem(){
		
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 100);
		
	}
	public static void testGetAllCartItems(){
		CartDao cartDao = new CartDaoCollectionImpl();
		try {
			List<MenuItem> menuListItem=cartDao.getAllCartItems(1);

			for(MenuItem m:menuListItem){
				System.out.println(m);
			}
			
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void testRemoveCartItem(){
		
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem(1, 100);
		try {
			cartDao.getAllCartItems(1);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
