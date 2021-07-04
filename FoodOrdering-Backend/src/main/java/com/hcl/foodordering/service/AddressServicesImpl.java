package com.hcl.foodordering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.foodordering.beans.Address;
import com.hcl.foodordering.dao.AddressDAO;
import com.hcl.foodordering.exception.FoodOrderException;


@Service
public class AddressServicesImpl implements IAddressServices {
	
	@Autowired
	AddressDAO addressDAO;

	@Override
	public Address addAddress(Address address) throws FoodOrderException {
		if(!addressDAO.findById(address.getId()).isPresent()) {
			return addressDAO.saveAndFlush(address);
			}else
				throw new FoodOrderException("Address id already exists");
	}

	@Override
	public Address updateAddress(Address address, int id) throws FoodOrderException {
		if(addressDAO.findById(address.getId()).isPresent()) {
			return addressDAO.saveAndFlush(address);
			}else
				throw new FoodOrderException("Address id doesn't exists");
	}

	@Override
	public boolean deleteAddress(int id) throws FoodOrderException {
		if(addressDAO.findById(id).isPresent()) {
			addressDAO.deleteById(id);
			return true;
			}else
				throw new FoodOrderException("Address id doesn't exists");
	}

	@Override
	public Address searchAddress(int id) throws FoodOrderException {
		if(addressDAO.findById(id).isPresent()) {	
			return addressDAO.getById(id);
			}else
				throw new FoodOrderException("Address id doesn't exists");
	}

	@Override
	public List<Address> displayAddress() {
		return addressDAO.findAll();
	}

}
