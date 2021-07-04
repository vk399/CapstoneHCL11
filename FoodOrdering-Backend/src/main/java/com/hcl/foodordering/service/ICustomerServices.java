package com.hcl.foodordering.service;

import java.util.List;

import com.hcl.foodordering.beans.Customer;
import com.hcl.foodordering.exception.FoodOrderException;

public interface ICustomerServices {
	
    public Customer addCustomer(Customer cus) throws FoodOrderException;
	
	public Customer updateCustomer(Customer cus,int id) throws FoodOrderException;

	public boolean deleteCustomer(int id) throws FoodOrderException;

	public Customer searchCustomer(int id) throws FoodOrderException;
	
	public List<Customer> displayCustomer();
	

}
