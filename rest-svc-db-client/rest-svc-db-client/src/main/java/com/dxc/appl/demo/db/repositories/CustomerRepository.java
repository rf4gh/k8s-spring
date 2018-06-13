package com.dxc.appl.demo.db.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dxc.appl.demo.db.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
