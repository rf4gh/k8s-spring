package com.dxc.appl.demo.restsvcnosqlclient.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dxc.appl.demo.restsvcnosqlclient.model.FilmWithActors;

public interface FilmWithActorsRepository extends MongoRepository<FilmWithActors, Long> {

	public Optional<FilmWithActors> findById(Long id);
	public List<FilmWithActors> findByCategory(String category);
}
