package com.hcl.foodordering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.foodordering.beans.*;
import com.hcl.foodordering.dao.CustomerDAO;
import com.hcl.foodordering.exception.FoodOrderException;

@Service
public class CustomerServicesImpl implements ICustomerServices {
	
	@Autowired
	CustomerDAO customerDAO;
	
	@Autowired
	ICartServices service;


	@Override
	public Customer addCustomer(Customer cus) throws FoodOrderException {
		if(!customerDAO.findById(cus.getId()).isPresent()) {
			cus=customerDAO.saveAndFlush(cus);
			Cart cart=new Cart();
			cart.setCustomer(cus);
			cart.setId(cus.getId());
			service.addCart(cart);
			return cus;
			}else
				throw new FoodOrderException("Customer id already exists");
	}

	@Override
	public Customer updateCustomer(Customer cus, int id) throws FoodOrderException {
		if(customerDAO.findById(cus.getId()).isPresent()) {
			return customerDAO.saveAndFlush(cus);
			}else
				throw new FoodOrderException("Customer id doesn't exists");
	}

	@Override
	public boolean deleteCustomer(int id) throws FoodOrderException {
		if(customerDAO.findById(id).isPresent()) {
			customerDAO.deleteById(id);
			return true;
			}else
				throw new FoodOrderException("Customer id doesn't exists");
	}

	@Override
	public Customer searchCustomer(int id) throws FoodOrderException {
		if(customerDAO.findById(id).isPresent()) {
			
			return customerDAO.getById(id);
			}else
				throw new FoodOrderException("Customer id doesn't exists");
	}

	@Override
	public List<Customer> displayCustomer() {
		return customerDAO.findAll();
	}

}
