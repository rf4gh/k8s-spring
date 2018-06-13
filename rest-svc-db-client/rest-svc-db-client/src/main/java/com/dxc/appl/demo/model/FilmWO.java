package com.dxc.appl.demo.model;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import com.dxc.appl.demo.db.entities.Film;
import com.dxc.appl.demo.db.entities.FilmActor;
import com.dxc.appl.demo.db.entities.FilmCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString
public class FilmWO extends WebObject {
	private static final long serialVersionUID = -8494386839845787279L;
	
	private int filmId;
	private String title;
	private String description;
	private List<Integer> filmActors;
	private List<Byte> filmCategories;
	private byte language_id;
	private byte rentalDuration;
	private BigDecimal replaCost;
	
	public FilmWO(final Film film) {
		super();
		this.filmId = film.getFilmId();
		this.title = film.getTitle();
		this.description = film.getDescription();
		
		this.filmActors = new LinkedList<>();
		for(FilmActor filmActor : film.getFilmActors()){
			filmActors.add(filmActor.getActor().getActorId());
		}
		
		this.filmCategories = new LinkedList<>();
		for(FilmCategory filmCat : film.getFilmCategories()){
			filmCategories.add(filmCat.getCategory().getCategoryId());
		}
		
		this.language_id = film.getLanguage1().getLanguageId();
		this.rentalDuration = film.getRentalDuration();
		this.replaCost = film.getReplacementCost();
	}
}

