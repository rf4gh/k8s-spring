package com.dxc.appl.demo.db.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dxc.appl.demo.db.entities.City;

public interface CityRepository extends CrudRepository<City, Integer> {

}
