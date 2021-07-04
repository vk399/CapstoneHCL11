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

import com.hcl.foodordering.beans.Address;
import com.hcl.foodordering.beans.ResponseMessage;
import com.hcl.foodordering.exception.FoodOrderException;
import com.hcl.foodordering.service.IAddressServices;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AddressController {
	
	@Autowired
    IAddressServices service;
	
	@GetMapping("/displayAddress")
	public ResponseEntity<List<Address>> displayIAddress(){
		return new ResponseEntity<List<Address>>(service.displayAddress(),HttpStatus.OK);
	}
	
	
	@PostMapping("/addAddress")
	public ResponseEntity<Address> addAddress(@RequestBody Address address) throws FoodOrderException {
		return new ResponseEntity<Address>(service.addAddress(address),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAddress/{id}")
	public ResponseEntity<Boolean> deleteAddress(@PathVariable int id) throws FoodOrderException {
		return new ResponseEntity<Boolean>(service.deleteAddress(id),HttpStatus.OK);
	}
	
	@PutMapping("/updateAddress/{id}")
     public ResponseEntity<Address> updateAddress(@PathVariable int id,@RequestBody Address address) throws FoodOrderException {
		return new ResponseEntity<Address>(service.updateAddress(address,id),HttpStatus.OK);
	} 
	
	@GetMapping("/searchAddress/{id}")
	public ResponseEntity<Address> searchAddress(@PathVariable int id) throws FoodOrderException{
		return new ResponseEntity<Address>(service.searchAddress(id),HttpStatus.OK);
	}
	@ExceptionHandler(FoodOrderException.class)
	public ResponseEntity<ResponseMessage> handleGlobalException(HttpServletRequest request,Exception ex){
		ResponseMessage rm=new ResponseMessage();
		rm.setMessage(ex.getMessage());
		rm.setErrorCode(404);
		return new ResponseEntity<ResponseMessage>(rm,HttpStatus.NOT_FOUND);
	}
	

}
