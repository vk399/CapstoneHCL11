package com.hcl.foodordering.service;

import java.util.List;

import com.hcl.foodordering.beans.Restaurant;
import com.hcl.foodordering.exception.FoodOrderException;


public interface IRestaurantServices {
	
    public Restaurant addRestaurant(Restaurant res) throws FoodOrderException;
	
	public Restaurant updateRestaurant(Restaurant res,int id) throws FoodOrderException;

	public boolean deleteRestaurant(int id) throws FoodOrderException;

	public Restaurant searchRestaurant(int id) throws FoodOrderException;
	
	public List<Restaurant> displayRestaurant();

}
