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

import com.hcl.foodordering.beans.ResponseMessage;
import com.hcl.foodordering.beans.Restaurant;
import com.hcl.foodordering.exception.FoodOrderException;
import com.hcl.foodordering.service.IRestaurantServices;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class RestaurantController {
	
	@Autowired
    IRestaurantServices service;

	@GetMapping("/displayRestaurant")
	public ResponseEntity<List<Restaurant>> displayRestaurant(){
		return new ResponseEntity<List<Restaurant>>(service.displayRestaurant(),HttpStatus.OK);
	}
	
	
	@PostMapping("/addRestaurant")
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant res) throws FoodOrderException {
		return new ResponseEntity<Restaurant>(service.addRestaurant(res),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteRestaurant/{id}")
	public ResponseEntity<Boolean> deleteRestaurant(@PathVariable int id) throws FoodOrderException {
		return new ResponseEntity<Boolean>(service.deleteRestaurant(id),HttpStatus.OK);
	}
	
	@PutMapping("/updateRestaurant/{id}")
     public ResponseEntity<Restaurant> updateRestaurant(@PathVariable int id,@RequestBody Restaurant res) throws FoodOrderException {
		return new ResponseEntity<Restaurant>(service.updateRestaurant(res,id),HttpStatus.OK);
	} 
	
	@GetMapping("/searchRestaurant/{id}")
	public ResponseEntity<Restaurant> searchRestaurant(@PathVariable int id) throws FoodOrderException{
		return new ResponseEntity<Restaurant>(service.searchRestaurant(id),HttpStatus.OK);
	}
	@ExceptionHandler(FoodOrderException.class)
	public ResponseEntity<ResponseMessage> handleGlobalException(HttpServletRequest request,Exception ex){
		ResponseMessage rm=new ResponseMessage();
		rm.setMessage(ex.getMessage());
		rm.setErrorCode(404);
		return new ResponseEntity<ResponseMessage>(rm,HttpStatus.NOT_FOUND);
	}
	

}
