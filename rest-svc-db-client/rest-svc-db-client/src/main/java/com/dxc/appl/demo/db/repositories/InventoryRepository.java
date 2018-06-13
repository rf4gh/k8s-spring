package com.dxc.appl.demo.db.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dxc.appl.demo.db.entities.Film;
import com.dxc.appl.demo.db.entities.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
	@Query("select i from Inventory i where i.film = ?1")
	List<Inventory> findAllInventoriesByFilm(Film film);
}
