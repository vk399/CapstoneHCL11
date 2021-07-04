package com.hcl.foodordering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.foodordering.beans.Cart;
import com.hcl.foodordering.dao.CartDAO;
import com.hcl.foodordering.exception.FoodOrderException;

@Service
public class CartServicesImpl implements ICartServices {

	@Autowired
	CartDAO cartDAO;

	@Override
	public Cart addCart(Cart cart) throws FoodOrderException {
		if(!cartDAO.findById(cart.getId()).isPresent()) {
		return cartDAO.saveAndFlush(cart);
		}else
			throw new FoodOrderException("Cart id already exists");
	}

	@Override
	public Cart updateCart(Cart cart, int id) throws FoodOrderException {
		if(cartDAO.findById(id).isPresent()) {
			return cartDAO.saveAndFlush(cart);
			}else
				throw new FoodOrderException("Cart id doesn't exists");
	}

	@Override
	public boolean deleteCart(int id) throws FoodOrderException {
		if(cartDAO.findById(id).isPresent()) {
			cartDAO.deleteById(id);
			return true;
			}else
				throw new FoodOrderException("Cart id doesn't exists");
		
	}

	@Override
	public Cart searchCart(int id) throws FoodOrderException {
		if(cartDAO.findById(id).isPresent()) {
			return cartDAO.getById(id);
			}else
				throw new FoodOrderException("Cart id doesn't exists");
	}

	@Override
	public List<Cart> displayCart() {
		return cartDAO.findAll();
	}

}
