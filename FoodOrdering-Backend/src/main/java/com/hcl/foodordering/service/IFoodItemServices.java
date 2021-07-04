package com.hcl.foodordering.service;

import java.util.List;

import com.hcl.foodordering.beans.FoodItem;
import com.hcl.foodordering.exception.FoodOrderException;

public interface IFoodItemServices {
	
    public FoodItem addFoodItem(FoodItem foodItem) throws FoodOrderException;
	
	public FoodItem updateFoodItem(FoodItem foodItem,int id) throws FoodOrderException;

	public boolean deleteFoodItem(int id) throws FoodOrderException;

	public FoodItem searchFoodItem(int id) throws FoodOrderException;
	
	public List<FoodItem> displayFoodItem();

}
