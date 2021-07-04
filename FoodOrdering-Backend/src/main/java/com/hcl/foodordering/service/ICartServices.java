package com.hcl.foodordering.service;

import java.util.List;

import com.hcl.foodordering.beans.Cart;
import com.hcl.foodordering.exception.FoodOrderException;

public interface ICartServices {
	
    public Cart addCart(Cart cart) throws FoodOrderException;
	
	public Cart updateCart(Cart cart,int id) throws FoodOrderException;

	public boolean deleteCart(int id) throws FoodOrderException;

	public Cart searchCart(int id) throws FoodOrderException;
	
	public List<Cart> displayCart();

}
