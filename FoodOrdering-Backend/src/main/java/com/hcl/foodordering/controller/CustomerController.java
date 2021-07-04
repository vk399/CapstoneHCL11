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

import com.hcl.foodordering.beans.Customer;
import com.hcl.foodordering.beans.ResponseMessage;
import com.hcl.foodordering.exception.FoodOrderException;
import com.hcl.foodordering.service.ICustomerServices;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
    ICustomerServices service;
	
	@GetMapping("/displayCustomer")
	public ResponseEntity<List<Customer>> displayCustomer(){
		return new ResponseEntity<List<Customer>>(service.displayCustomer(),HttpStatus.OK);
	}
	
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer cus) throws FoodOrderException {
		return new ResponseEntity<Customer>(service.addCustomer(cus),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<Boolean> deleteCustomer(@PathVariable int id) throws FoodOrderException {
		return new ResponseEntity<Boolean>(service.deleteCustomer(id),HttpStatus.OK);
	}
	
	@PutMapping("/updateCustomer/{id}")
     public ResponseEntity<Customer> updateCustomer(@PathVariable int id,@RequestBody Customer cus) throws FoodOrderException {
		return new ResponseEntity<Customer>(service.updateCustomer(cus,id),HttpStatus.OK);
	} 
	
	@GetMapping("/searchCustomer/{id}")
	public ResponseEntity<Customer> searchCustomer(@PathVariable int id) throws FoodOrderException{
		return new ResponseEntity<Customer>(service.searchCustomer(id),HttpStatus.OK);
	}
	
	@ExceptionHandler(FoodOrderException.class)
	public ResponseEntity<ResponseMessage> handleGlobalException(HttpServletRequest request,Exception ex){
		ResponseMessage rm=new ResponseMessage();
		rm.setMessage(ex.getMessage());
		rm.setErrorCode(404);
		return new ResponseEntity<ResponseMessage>(rm,HttpStatus.NOT_FOUND);
	}
	

}
