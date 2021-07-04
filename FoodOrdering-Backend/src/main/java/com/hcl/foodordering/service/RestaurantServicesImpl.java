package com.hcl.foodordering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.foodordering.beans.Restaurant;
import com.hcl.foodordering.dao.RestaurantDAO;
import com.hcl.foodordering.exception.FoodOrderException;

@Service
public class RestaurantServicesImpl implements IRestaurantServices {
	
	@Autowired
	RestaurantDAO restaurantDAO;

	@Override
	public Restaurant addRestaurant(Restaurant res) throws FoodOrderException {
		if(!restaurantDAO.findById(res.getResId()).isPresent()) {
		return restaurantDAO.saveAndFlush(res);
		}else
			throw new FoodOrderException("Restaurant id already exists");
	}

	@Override
	public Restaurant updateRestaurant(Restaurant res, int id) throws FoodOrderException {
		if(restaurantDAO.findById(id).isPresent()) {
			return restaurantDAO.saveAndFlush(res);
			}else
				throw new FoodOrderException("Restaurant id doesn't exists");
	}

	@Override
	public boolean deleteRestaurant(int id) throws FoodOrderException {
		if(restaurantDAO.findById(id).isPresent()) {
			restaurantDAO.deleteById(id);
			return true;
			}else
				throw new FoodOrderException("Restaurant id doesn't exists");
		
	}

	@Override
	public Restaurant searchRestaurant(int id) throws FoodOrderException {
		if(restaurantDAO.findById(id).isPresent()) {
			return restaurantDAO.getById(id);
			}else
				throw new FoodOrderException("Restaurant id doesn't exists");
	}

	@Override
	public List<Restaurant> displayRestaurant() {
		return restaurantDAO.findAll();
	}

}
