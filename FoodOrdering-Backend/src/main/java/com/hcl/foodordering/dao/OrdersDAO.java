package com.hcl.foodordering.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.foodordering.beans.Orders;

@Repository
public interface OrdersDAO extends JpaRepository<Orders,Integer>{

}
