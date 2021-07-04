package com.hcl.foodordering.service;

import java.util.List;

import com.hcl.foodordering.beans.Address;
import com.hcl.foodordering.exception.FoodOrderException;

public interface IAddressServices {
	
    public Address addAddress(Address address) throws FoodOrderException;
	
	public Address updateAddress(Address address,int id) throws FoodOrderException;

	public boolean deleteAddress(int id) throws FoodOrderException;

	public Address searchAddress(int id) throws FoodOrderException;
	
	public List<Address> displayAddress();

}