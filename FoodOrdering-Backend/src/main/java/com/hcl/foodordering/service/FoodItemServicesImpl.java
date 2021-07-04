package com.hcl.foodordering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.foodordering.beans.FoodItem;
import com.hcl.foodordering.dao.FoodItemDAO;
import com.hcl.foodordering.exception.FoodOrderException;

@Service
public class FoodItemServicesImpl implements IFoodItemServices {

	@Autowired
	FoodItemDAO foodItemDAO;
	
	@Override
	public FoodItem addFoodItem(FoodItem foodItem) throws FoodOrderException {
		if(!foodItemDAO.findById(foodItem.getId()).isPresent()) {
			return foodItemDAO.saveAndFlush(foodItem);
			}else
				throw new FoodOrderException("FoodItem id already exists");
	}

	@Override
	public FoodItem updateFoodItem(FoodItem foodItem, int id) throws FoodOrderException {
		if(foodItemDAO.findById(foodItem.getId()).isPresent()) {
			return foodItemDAO.saveAndFlush(foodItem);
			}else
				throw new FoodOrderException("FoodItem id doesn't exists");
	}

	@Override
	public boolean deleteFoodItem(int id) throws FoodOrderException {
		if(foodItemDAO.findById(id).isPresent()) {
			foodItemDAO.deleteById(id);
			return true;
			}else
				throw new FoodOrderException("FoodItem id doesn't exists");
	}

	@Override
	public FoodItem searchFoodItem(int id) throws FoodOrderException {
		if(foodItemDAO.findById(id).isPresent()) {
			return foodItemDAO.getById(id);
			}else
				throw new FoodOrderException("FoodItem id doesn't exists");
	}

	@Override
	public List<FoodItem> displayFoodItem() {
		return foodItemDAO.findAll();
	}

}
