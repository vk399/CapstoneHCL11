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
import com.hcl.foodordering.beans.Orders;
import com.hcl.foodordering.exception.FoodOrderException;
import com.hcl.foodordering.service.IOrdersServices;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class OrdersController {
	
	@Autowired
    IOrdersServices service;
	

	
	@GetMapping("/displayOrders")
	public ResponseEntity<List<Orders>> displayOrders(){
		return new ResponseEntity<List<Orders>>(service.displayOrders(),HttpStatus.OK);
	}
	
	
	@PostMapping("/addOrders")
	public ResponseEntity<Orders> addOrders(@RequestBody Orders order) throws FoodOrderException {
		return new ResponseEntity<Orders>(service.addOrders(order),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteOrders/{id}")
	public ResponseEntity<Boolean> deleteOrders(@PathVariable int id) throws FoodOrderException {
		return new ResponseEntity<Boolean>(service.deleteOrders(id),HttpStatus.OK);
	}
	
	@PutMapping("/updateOrders/{id}")
     public ResponseEntity<Orders> updateOrders(@PathVariable int id,@RequestBody Orders order) throws FoodOrderException {
		return new ResponseEntity<Orders>(service.updateOrders(order,id),HttpStatus.OK);
	} 
	
	@GetMapping("/searchOrders/{id}")
	public ResponseEntity<Orders> searchOrders(@PathVariable int id) throws FoodOrderException{
		return new ResponseEntity<Orders>(service.searchOrders(id),HttpStatus.OK);
	}
	@ExceptionHandler(FoodOrderException.class)
	public ResponseEntity<ResponseMessage> handleGlobalException(HttpServletRequest request,Exception ex){
		ResponseMessage rm=new ResponseMessage();
		rm.setMessage(ex.getMessage());
		rm.setErrorCode(404);
		return new ResponseEntity<ResponseMessage>(rm,HttpStatus.NOT_FOUND);
	}
	

}