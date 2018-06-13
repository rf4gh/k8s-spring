package com.dxc.appl.demo.db.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the film_text database table.
 * 
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="film_text")
@NamedQuery(name="FilmText.findAll", query="SELECT f FROM FilmText f")
public class FilmText implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	// https://vladmihalcea.com/why-should-not-use-the-auto-jpa-generationtype-with-mysql-and-hibernate/
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="film_id", unique=true, nullable=false)
	private short filmId;

	@Lob
	private String description;

	@Column(nullable=false, length=255)
	private String title;

}