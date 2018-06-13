package com.dxc.appl.demo.svc.entitysvc;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.appl.demo.db.entities.City;
import com.dxc.appl.demo.db.repositories.CityRepository;
import com.dxc.appl.demo.model.CityWO;

@Service("cityService")
@Transactional
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;

	// log
	private static final Log log = LogFactory.getLog(CityServiceImpl.class);

	
	// find all cities
	@Override
	public List<CityWO> findAllCities() {
		List<CityWO> cities = new LinkedList<CityWO>();

		for (City city : cityRepository.findAll()) {
			cities.add(new CityWO(city));
			log.debug("Adding " + city);
		}

		return cities;
	}

	
	// find by id
	@Override
	public CityWO findById(int id) {

		log.debug(String.format("Looking for city by Id %s", id));

//		City city = cityRepository.findOne(id);
		Optional<City> optCity = cityRepository.findById(id);

		if (optCity.isPresent()) {
			return new CityWO(optCity.get());
		}
		return null;
	}
}
