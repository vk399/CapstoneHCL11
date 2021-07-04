package com.hcl.foodordering.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.foodordering.beans.Cart;
import com.hcl.foodordering.beans.ResponseMessage;
import com.hcl.foodordering.exception.FoodOrderException;
import com.hcl.foodordering.service.ICartServices;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CartController {
	
	@Autowired
    ICartServices service;
	
	@GetMapping("/displayCart")
	public ResponseEntity<List<Cart>> displayCart(){
		return new ResponseEntity<List<Cart>>(service.displayCart(),HttpStatus.OK);
	}
	
	
	@PostMapping("/addCart")
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart) throws FoodOrderException {
		return new ResponseEntity<Cart>(service.addCart(cart),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCart/{id}")
	public ResponseEntity<Boolean> deleteCart(@PathVariable int id) throws FoodOrderException {
		return new ResponseEntity<Boolean>(service.deleteCart(id),HttpStatus.OK);
	}
	
	@PutMapping("/updateCart/{id}")
     public ResponseEntity<Cart> updateCart(@PathVariable int id,@RequestBody Cart cart) throws FoodOrderException {
		return new ResponseEntity<Cart>(service.updateCart(cart,id),HttpStatus.OK);
	} 
	
	@GetMapping("/searchCart/{id}")
	public ResponseEntity<Cart> searchCart(@PathVariable int id) throws FoodOrderException{
		return new ResponseEntity<Cart>(service.searchCart(id),HttpStatus.OK);
	}
	@ExceptionHandler(FoodOrderException.class)
	public ResponseEntity<ResponseMessage> handleGlobalException(HttpServletRequest request,Exception ex){
		ResponseMessage rm=new ResponseMessage();
		rm.setMessage(ex.getMessage());
		rm.setErrorCode(404);
		return new ResponseEntity<ResponseMessage>(rm,HttpStatus.NOT_FOUND);
	}
	

}
