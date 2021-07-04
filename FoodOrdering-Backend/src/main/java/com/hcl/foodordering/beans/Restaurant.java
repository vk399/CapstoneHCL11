package com.hcl.foodordering.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="restaurant")
public class Restaurant {
	
	@Id
	@Column(name="id")
	private int resId;
	
	@Column(name="restaurant_name")
	private String restaurantName;
	
	@Column(name="location")
	private String location;
	
	@Column(name="number")
	private int number;

}
