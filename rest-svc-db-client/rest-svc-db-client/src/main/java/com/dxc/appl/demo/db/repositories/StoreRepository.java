package com.dxc.appl.demo.db.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dxc.appl.demo.db.entities.Store;

public interface StoreRepository extends CrudRepository<Store, Byte> {

}
