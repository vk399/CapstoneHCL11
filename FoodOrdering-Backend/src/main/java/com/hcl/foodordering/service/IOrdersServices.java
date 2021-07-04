package com.hcl.foodordering.service;

import java.util.List;

import com.hcl.foodordering.beans.Orders;
import com.hcl.foodordering.exception.FoodOrderException;

public interface IOrdersServices {
	
    public Orders addOrders(Orders order) throws FoodOrderException;
	
	public Orders updateOrders(Orders order,int id) throws FoodOrderException;

	public boolean deleteOrders(int id) throws FoodOrderException;

	public Orders searchOrders(int id) throws FoodOrderException;
	
	public List<Orders> displayOrders();


}
