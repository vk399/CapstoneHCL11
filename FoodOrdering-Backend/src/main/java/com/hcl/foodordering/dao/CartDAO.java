package com.hcl.foodordering.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.foodordering.beans.Cart;


@Repository
public interface CartDAO extends JpaRepository<Cart,Integer>{

}
