package com.hcl.foodordering.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cartvalues")
public class CartValues {
	
	@Id
	@Column(name ="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name = "total_quantity")
	private int quantity;

	@Column(name = "total_price")
	private double price;


	@ManyToOne
	private FoodItem foodItem;
	
	@ManyToOne
	private Cart cart;

}
