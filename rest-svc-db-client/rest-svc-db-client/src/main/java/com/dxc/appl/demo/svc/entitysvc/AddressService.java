package com.dxc.appl.demo.svc.entitysvc;

import java.util.List;

import com.dxc.appl.demo.db.entities.Address;
import com.dxc.appl.demo.model.AddressWO;

public interface AddressService {

	AddressWO findById(int id);

	Address saveAddress(AddressWO addressWO);

	void updateAddress(AddressWO addressWO);

	void deleteAddressById(int id);

	List<AddressWO> findAllAddresss();

}