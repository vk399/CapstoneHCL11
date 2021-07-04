package com.hcl.foodordering.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.foodordering.beans.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer,Integer>{

}

