package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.businessLogic.BusinessLogic;
import com.example.demo.dao.CategoriesDAO;
import com.example.demo.dto.CategoriesDTO;
import com.example.demo.model.Categories;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
	
	@Autowired
	BusinessLogic businessLogic;

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
	public Categories saveUser(@RequestBody CategoriesDTO categoryDTO) {
		return (businessLogic.save(categoryDTO));
	}
}