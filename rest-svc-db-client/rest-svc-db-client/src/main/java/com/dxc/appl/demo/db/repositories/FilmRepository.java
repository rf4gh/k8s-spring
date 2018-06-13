package com.dxc.appl.demo.db.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dxc.appl.demo.db.entities.Film;

public interface FilmRepository extends CrudRepository<Film, Integer> {

}
