package com.dxc.appl.demo.svc.entitysvc;

import java.util.List;

import com.dxc.appl.demo.model.StoreWO;

public interface StoreService {
	
	StoreWO findById(int id);

	void saveStore(StoreWO storeWO);

	void updateStore(StoreWO storeWO);

	void deleteStoreById(int id);

	List<StoreWO> findAllStores();
}
