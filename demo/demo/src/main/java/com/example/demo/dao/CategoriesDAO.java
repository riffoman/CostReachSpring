package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.Categories;

@Component
public interface CategoriesDAO extends CrudRepository<Categories, Long> {
	public Categories findOneByName(String name);
	
	public Categories save(Categories persisted);
}