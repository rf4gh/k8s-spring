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

import com.dxc.appl.demo.db.entities.Film;
import com.dxc.appl.demo.db.entities.Language;
import com.dxc.appl.demo.db.repositories.FilmActorRepository;
import com.dxc.appl.demo.db.repositories.FilmCategoryRepository;
import com.dxc.appl.demo.db.repositories.FilmRepository;
import com.dxc.appl.demo.db.repositories.LanguageRepository;
import com.dxc.appl.demo.model.FilmWO;

@Service("filmService")
@Transactional
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private LanguageRepository languageRepository;

	@Autowired
	private FilmCategoryRepository filmCategoryRepository;

	@Autowired
	private FilmActorRepository filmActorRepository;

	// Log
	private static final Log log = LogFactory.getLog(FilmServiceImpl.class);

	// find all films
	public List<FilmWO> findAllFilms() {
		List<FilmWO> films = new LinkedList<FilmWO>();

		for (Film film : filmRepository.findAll()) {
			films.add(new FilmWO(film));
			log.debug("Adding " + film);
		}

		return films;
	}

	// find film by id
	public FilmWO findById(int id) {
		log.debug(String.format("Looking for user by Id %s", id));
//		Film film = filmRepository.findOne(id);
		Optional<Film> optFilm = filmRepository.findById(id);

		if (optFilm.isPresent()) {
			return new FilmWO(optFilm.get());
		}
		return null;
	}

	// save a film
	public void saveFilm(FilmWO filmWO) {
		Film film = new Film();

		film.setTitle(filmWO.getTitle());
		film.setDescription(filmWO.getDescription());
		film.setRentalDuration(filmWO.getRentalDuration());
		film.setReplacementCost(filmWO.getReplaCost());

//		Language language = languageRepository.findOne(filmWO.getLanguage_id());
		Optional<Language> optLang = languageRepository.findById(filmWO.getLanguage_id());
		if (optLang.isPresent()) {
			film.setLanguage1(optLang.get());
		}

		filmRepository.save(film);
	}

	// update a film
	public void updateFilm(FilmWO filmWO) {
//		Film film2update = filmRepository.findOne(filmWO.getFilmId());
		Optional<Film> optFilm = filmRepository.findById(filmWO.getFilmId());

		optFilm.get().setTitle(filmWO.getTitle());
		optFilm.get().setDescription(filmWO.getDescription());
		optFilm.get().setRentalDuration(filmWO.getRentalDuration());
		optFilm.get().setReplacementCost(filmWO.getReplaCost());

		optFilm.get().setLastUpdate(new Timestamp(System.currentTimeMillis()));
		filmRepository.save(optFilm.get());
	}

	// delete film by id
	public void deleteFilmById(int id) {
		filmRepository.deleteById(id);
	}
}
