package com.hcl.foodordering.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.foodordering.beans.FoodItem;

@Repository
public interface FoodItemDAO extends JpaRepository<FoodItem,Integer>{

}
