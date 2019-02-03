package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.businessLogic.CRUDLogic;
import com.example.demo.dto.CategoriesDTO;
import com.example.demo.exceptionHandlers.MandatoryDataMissingException;
import com.example.demo.model.Categories;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
	
	@Autowired
	CRUDLogic businessLogic;

	@GetMapping
	@ResponseBody
	public List<CategoriesDTO> findAll() {
		return businessLogic.getAllCategories();
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ResponseBody
	public CategoriesDTO findOneByName(@PathVariable("name") String name) {
		return businessLogic.getCategoryByName(name);
	}

	@PostMapping
	public Categories createCategory(@RequestBody CategoriesDTO categoryDTO) throws MandatoryDataMissingException {
		if(categoryDTO.getName()==null) {
			throw new MandatoryDataMissingException("Nema dovoljno podataka");
		}
		return (businessLogic.createCategory(categoryDTO));
	}
	
	@PutMapping
	public Categories updateCategory(@RequestBody Categories categories) {
		return (businessLogic.updateCategory(categories));
	}
	
	@DeleteMapping
	public void deleteCategory(@RequestBody Categories categories) {
		businessLogic.deleteCategory(categories);
	}
}