package com.dxc.appl.demo.db.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dxc.appl.demo.db.entities.FilmCategory;

public interface FilmCategoryRepository extends CrudRepository<FilmCategory, Byte> {

}
