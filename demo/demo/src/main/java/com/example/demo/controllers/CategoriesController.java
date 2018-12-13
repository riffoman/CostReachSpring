package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CategoriesDAO;
import com.example.demo.model.Categories;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
	@Autowired
	CategoriesDAO categoriesDAO;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Categories> findAll() {
		return (ArrayList<Categories>) categoriesDAO.findAll();
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ResponseBody
	public Categories findOne(@PathVariable("name") String name) {
		return (categoriesDAO.findOneByName(name));
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Categories saveUser(@RequestBody Categories persisted) {
		return (categoriesDAO.save(persisted));
	}
}