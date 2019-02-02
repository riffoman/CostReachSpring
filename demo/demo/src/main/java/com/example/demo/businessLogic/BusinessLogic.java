package com.example.demo.businessLogic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CategoriesDAO;
import com.example.demo.dao.UsersDAO;
import com.example.demo.dto.CategoriesDTO;
import com.example.demo.model.Categories;
import com.example.demo.model.Users;

@Service
public class BusinessLogic {
	@Autowired
	CategoriesDAO categoriesDAO;

	@Autowired
	UsersDAO usersDAO;
	
	public List<CategoriesDTO> getAllCategories() {
		List<CategoriesDTO> listOfAllCategories=new ArrayList<>();
		for(Categories categories:categoriesDAO.findAll()) {
			CategoriesDTO categoriesDTO=new CategoriesDTO(categories);
			listOfAllCategories.add(categoriesDTO);
		}
		return listOfAllCategories;
	}

	public CategoriesDTO getCategoryByName(String name) {
		CategoriesDTO categoriesDTO=new CategoriesDTO(categoriesDAO.findOneByName(name));
		return categoriesDTO;
	}

	public Categories save(CategoriesDTO categoryDTO) {
		Users user=usersDAO.findOneByUsername(categoryDTO.getUserName());
		Categories categories=new Categories();
		categories.setName(categoryDTO.getName());
		categories.setUser(user);
		
		return categoriesDAO.save(categories);
	}

}
