package com.dxc.appl.demo.db.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the film database table.
 * 
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="film")
@NamedQuery(name="Film.findAll", query="SELECT f FROM Film f")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	// https://vladmihalcea.com/why-should-not-use-the-auto-jpa-generationtype-with-mysql-and-hibernate/
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="film_id", unique=true, nullable=false)
	private int filmId;

	@Lob
	private String description;

	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;

	private int length;

	@Column(length=1)
	private String rating;

	@Temporal(TemporalType.DATE)
	@Column(name="release_year")
	private Date releaseYear;

	@Column(name="rental_duration", nullable=false)
	private byte rentalDuration;

	@Column(name="rental_rate", nullable=false, precision=10, scale=2)
	private BigDecimal rentalRate;

	@Column(name="replacement_cost", nullable=false, precision=10, scale=2)
	private BigDecimal replacementCost;

	@Column(name="special_features")
	private String specialFeatures;

	@Column(nullable=false, length=255)
	private String title;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="language_id", nullable=false)
	private Language language1;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="original_language_id")
	private Language language2;

	//bi-directional many-to-one association to FilmActor
	@OneToMany(mappedBy="film")
	private List<FilmActor> filmActors;

	//bi-directional many-to-one association to FilmCategory
	@OneToMany(mappedBy="film")
	private List<FilmCategory> filmCategories;

	//bi-directional many-to-one association to Inventory
	@OneToMany(mappedBy="film")
	private List<Inventory> inventories;

	public FilmActor addFilmActor(FilmActor filmActor) {
		getFilmActors().add(filmActor);
		filmActor.setFilm(this);

		return filmActor;
	}

	public FilmActor removeFilmActor(FilmActor filmActor) {
		getFilmActors().remove(filmActor);
		filmActor.setFilm(null);

		return filmActor;
	}

	public FilmCategory addFilmCategory(FilmCategory filmCategory) {
		getFilmCategories().add(filmCategory);
		filmCategory.setFilm(this);

		return filmCategory;
	}

	public FilmCategory removeFilmCategory(FilmCategory filmCategory) {
		getFilmCategories().remove(filmCategory);
		filmCategory.setFilm(null);

		return filmCategory;
	}

	public Inventory addInventory(Inventory inventory) {
		getInventories().add(inventory);
		inventory.setFilm(this);

		return inventory;
	}

	public Inventory removeInventory(Inventory inventory) {
		getInventories().remove(inventory);
		inventory.setFilm(null);

		return inventory;
	}
}