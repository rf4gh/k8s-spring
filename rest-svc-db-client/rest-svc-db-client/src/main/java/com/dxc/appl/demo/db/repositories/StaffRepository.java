package com.dxc.appl.demo.db.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dxc.appl.demo.db.entities.Staff;

public interface StaffRepository extends CrudRepository<Staff, Integer> {

}
