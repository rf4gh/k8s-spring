package com.dxc.appl.demo.svc.businesssvc;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.appl.demo.db.entities.Actor;
import com.dxc.appl.demo.db.entities.Address;
import com.dxc.appl.demo.db.entities.City;
import com.dxc.appl.demo.db.entities.Customer;
import com.dxc.appl.demo.db.entities.Film;
import com.dxc.appl.demo.db.entities.Staff;
import com.dxc.appl.demo.db.repositories.ActorRepository;
import com.dxc.appl.demo.db.repositories.AddressRepository;
import com.dxc.appl.demo.db.repositories.CityRepository;
import com.dxc.appl.demo.db.repositories.CustomerRepository;
import com.dxc.appl.demo.db.repositories.FilmRepository;
import com.dxc.appl.demo.db.repositories.StaffRepository;
import com.dxc.appl.demo.svc.IBusiness;
import com.google.common.collect.Lists;


@Service("business")
public class Business implements IBusiness {

	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private StaffRepository staffRepository;
	
	@Override
	public List<Actor> getAllActors() {
		// TODO Auto-generated method stub
		return Lists.newArrayList(actorRepository.findAll());
	}

	@Override
	public Actor getByID(int actorId) {
		Optional<Actor> optActor = actorRepository.findById(actorId);
		return optActor.isPresent() ? optActor.get() : null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return Lists.newArrayList(customerRepository.findAll());
	}

	@Override
	public Customer getByCustomerID(int customerId) {
		Optional<Customer> optCust = customerRepository.findById(customerId);
		return optCust.isPresent() ? optCust.get() : null;
	}

	@Override
	public List<Address> getAllAddresses() {
		// TODO Auto-generated method stub
		return Lists.newArrayList(addressRepository.findAll());
	}

	@Override
	public Address getByAddressID(int addressId) {
		Optional<Address> optAddr = addressRepository.findById(addressId);
		return optAddr.isPresent() ? optAddr.get() : null;
	}

	@Override
	public List<City> getAllCities() {
		// TODO Auto-generated method stub
		return Lists.newArrayList(cityRepository.findAll());
	}

	@Override
	public City getByCityID(int cityId) {
		Optional<City> optCity = cityRepository.findById(cityId);
		return optCity.isPresent() ? optCity.get() : null;
	}

	@Override
	public List<Film> getAllFilms() {
		// TODO Auto-generated method stub
		return Lists.newArrayList(filmRepository.findAll());
	}

	@Override
	public Film getByFilmID(int filmId) {
		Optional<Film> optFilm = filmRepository.findById(filmId);
		return optFilm.isPresent() ? optFilm.get() : null;
	}

	@Override
	public List<Staff> getAllStaffs() {
		// TODO Auto-generated method stub
		return Lists.newArrayList(staffRepository.findAll());
	}

	@Override
	public Staff getByStaffID(int staffId) {
		Optional<Staff> optStaff = staffRepository.findById(staffId);
		return optStaff.isPresent() ? optStaff.get() : null;
	}

}
