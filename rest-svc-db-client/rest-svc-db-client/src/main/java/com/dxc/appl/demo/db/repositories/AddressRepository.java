package com.dxc.appl.demo.db.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dxc.appl.demo.db.entities.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {

}
