package com.dxc.appl.demo.svc.entitysvc;

import java.util.List;

import com.dxc.appl.demo.model.CityWO;

public interface CityService {

	CityWO findById(int id);

	List<CityWO> findAllCities();

}
