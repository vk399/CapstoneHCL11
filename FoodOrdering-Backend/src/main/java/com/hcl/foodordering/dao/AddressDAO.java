package com.hcl.foodordering.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.foodordering.beans.Address;


@Repository
public interface AddressDAO extends JpaRepository<Address,Integer>{

}