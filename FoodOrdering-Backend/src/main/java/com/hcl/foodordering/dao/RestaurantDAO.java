package com.hcl.foodordering.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.foodordering.beans.Restaurant;

@Repository
public interface RestaurantDAO extends JpaRepository<Restaurant,Integer>{

}