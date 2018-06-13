package com.dxc.appl.demo.db.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dxc.appl.demo.db.entities.FilmActor;

public interface FilmActorRepository extends CrudRepository<FilmActor, Integer> {

}