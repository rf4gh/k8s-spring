package com.dxc.appl.demo.svc.entitysvc;

import java.util.List;

import com.dxc.appl.demo.model.FilmWO;

public interface FilmService {
	FilmWO findById(int id);

	void saveFilm(FilmWO filmWO);

	void updateFilm(FilmWO filmWO);

	void deleteFilmById(int id);

	List<FilmWO> findAllFilms();

}