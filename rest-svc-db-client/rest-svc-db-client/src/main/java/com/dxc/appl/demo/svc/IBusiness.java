package com.dxc.appl.demo.svc;

import java.util.List;

import com.dxc.appl.demo.db.entities.Actor;
import com.dxc.appl.demo.db.entities.Address;
import com.dxc.appl.demo.db.entities.City;
import com.dxc.appl.demo.db.entities.Customer;
import com.dxc.appl.demo.db.entities.Film;
import com.dxc.appl.demo.db.entities.Staff;

public interface IBusiness {
	
	public List<Actor> getAllActors();
	
	public Actor getByID(int actorId);
	
	public List<Customer> getAllCustomers();
	
	public Customer getByCustomerID(int customerId);
	
	public List<Address> getAllAddresses();
	
	public Address getByAddressID(int addressId);
	
	public List<City> getAllCities();
	
	public City getByCityID(int cityId);
	
	public List<Film> getAllFilms();
	
	public Film getByFilmID(int filmId);
	
	public List<Staff> getAllStaffs();
	
	public Staff getByStaffID(int staffId);
}
