package com.dxc.appl.demo.svc.entitysvc;

import java.util.List;

import com.dxc.appl.demo.model.RentalWO;

public interface RentalService {

	List<RentalWO> findAllRentals();

	RentalWO findById(int id);

}