package com.hcl.foodordering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.foodordering.beans.Orders;
import com.hcl.foodordering.dao.OrdersDAO;
import com.hcl.foodordering.exception.FoodOrderException;

@Service
public class OrdersServicesImpl implements IOrdersServices {
	
	@Autowired
	OrdersDAO orderDAO;

	@Override
	public Orders addOrders(Orders order) throws FoodOrderException {
			return orderDAO.saveAndFlush(order);
	}

	@Override
	public Orders updateOrders(Orders order, int id) throws FoodOrderException {
		if(orderDAO.findById(order.getId()).isPresent()) {
			return orderDAO.saveAndFlush(order);
			}else
				throw new FoodOrderException("Order id doesn't exists");
	}

	@Override
	public boolean deleteOrders(int id) throws FoodOrderException {
		if(orderDAO.findById(id).isPresent()) {
			orderDAO.deleteById(id);
			return true;
			}else
				throw new FoodOrderException("Order id doesn't exists");
	}

	@Override
	public Orders searchOrders(int id) throws FoodOrderException {
		if(orderDAO.findById(id).isPresent()) {
			return orderDAO.getById(id);
			}else
				throw new FoodOrderException("Order id doesn't exists");
	}

	@Override
	public List<Orders> displayOrders() {
		return orderDAO.findAll();
	}

}
