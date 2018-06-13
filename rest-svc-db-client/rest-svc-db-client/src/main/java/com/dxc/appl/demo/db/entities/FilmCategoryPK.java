package com.dxc.appl.demo.db.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The primary key class for the film_category database table.
 * 
 */
@Embeddable
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class FilmCategoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="film_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int filmId;

	@Column(name="category_id", insertable=false, updatable=false, unique=true, nullable=false)
	private byte categoryId;
}