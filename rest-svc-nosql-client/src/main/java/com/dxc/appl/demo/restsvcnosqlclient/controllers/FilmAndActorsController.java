package com.dxc.appl.demo.restsvcnosqlclient.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.appl.demo.restsvcnosqlclient.model.FilmWithActors;
import com.dxc.appl.demo.restsvcnosqlclient.repo.FilmWithActorsRepository;

@RestController
public class FilmAndActorsController {

	@Autowired
	private FilmWithActorsRepository repository;
	
	@GetMapping(value="/films", params={ "id" })
	public FilmWithActors getFilmById(@RequestParam Long id) {
		
		Optional<FilmWithActors> film = repository.findById(id);
		if( film.isPresent() )
			return film.get();
		else
			return null;
	}
	
	@GetMapping(value="/films", params={ "category" })
	public List<FilmWithActors> getFilmsByCategory(@RequestParam String category) {
		
		return repository.findByCategory(category);
	}
}
