package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.businessLogic.CRUDLogic;
import com.example.demo.dto.CategoriesDTO;
import com.example.demo.exceptionHandlers.MandatoryDataMissingException;
import com.example.demo.model.Categories;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/categories")
public class CategoriesController {

	@Autowired
	CRUDLogic businessLogic;

	@GetMapping
	@ResponseBody
	public List<CategoriesDTO> findAll() {
		log.info("metoda koja vraca sve kategorije");
		return businessLogic.getAllCategories();
	}

	@GetMapping(value = "/{name}")
	@ResponseBody
	public CategoriesDTO findOneByName(@PathVariable("name") String name) {
		log.info("metoda koja vraca kategoriju u zavisnostiod imena kategorije");
		return businessLogic.getCategoryByName(name);
	}

	@PostMapping
	public Categories createCategory(@RequestBody @Valid CategoriesDTO categoryDTO, Errors errors)
			throws MandatoryDataMissingException {
		if (errors.hasErrors()) {
			throw new MandatoryDataMissingException(errors.getFieldError().getDefaultMessage());
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