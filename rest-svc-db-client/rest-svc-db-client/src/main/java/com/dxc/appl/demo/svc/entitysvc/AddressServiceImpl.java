package com.dxc.appl.demo.svc.entitysvc;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.appl.demo.db.entities.Address;
import com.dxc.appl.demo.db.entities.City;
import com.dxc.appl.demo.db.repositories.AddressRepository;
import com.dxc.appl.demo.db.repositories.CityRepository;
import com.dxc.appl.demo.model.AddressWO;

@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private CityRepository cityRepository;

	// log
	private static final Log log = LogFactory.getLog(AddressServiceImpl.class);

	// find all address
	@Override
	public List<AddressWO> findAllAddresss() {
		List<AddressWO> addresss = new LinkedList<AddressWO>();

		for (Address address : addressRepository.findAll()) {
			addresss.add(new AddressWO(address));
			log.debug("Adding " + address);
		}

		return addresss;
	}

	// find by id
	@Override
	public AddressWO findById(int id) {
		log.debug(String.format("Looking for user by Id %s", id));
//		Address address = addressRepository.findOne(id)
		Optional<Address> optAddr = addressRepository.findById(id);

		if (optAddr.isPresent()) {
			return new AddressWO(optAddr.get());
		}
		return null;
	}

	// save address
	@Override
	public Address saveAddress(AddressWO addressWO) {
		Address address = new Address();
		address.setAddress(addressWO.getAddress());
		address.setAddress2(addressWO.getAddress2());
		address.setDistrict(addressWO.getDistrict());
		address.setPostalCode(addressWO.getPostal_code());
		address.setPhone("");

//		City city = cityRepository.findOne(addressWO.getCity_id());
		Optional<City> optCity = cityRepository.findById(addressWO.getCity_id());
		if (optCity.isPresent()) {
			address.setCity(optCity.get());
		}

		address.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		Address newAddress = addressRepository.save(address);
		addressRepository.save(address);

		return newAddress;
	}

	// update
	@Override
	public void updateAddress(AddressWO addressWO) {

//		Address address2update = addressRepository.findOne(addressWO.getAddressId());
		Optional<Address> optAddr = addressRepository.findById(addressWO.getAddressId());
		optAddr.get().setAddress(addressWO.getAddress());
		optAddr.get().setAddress2(addressWO.getAddress2());
		optAddr.get().setDistrict(addressWO.getDistrict());
		optAddr.get().setPostalCode(addressWO.getPostal_code());

//		City city = cityRepository.findOne(addressWO.getCity_id());
		Optional<City> optCity = cityRepository.findById(addressWO.getCity_id());
		if (optCity.isPresent()) {
			optAddr.get().setCity(optCity.get());
		}

		optAddr.get().setLastUpdate(new Timestamp(System.currentTimeMillis()));
		addressRepository.save(optAddr.get());
	}

	// delete by id
	@Override
	public void deleteAddressById(int id) {
//		addressRepository.delete(id);
		addressRepository.deleteById(id);
	}
}
