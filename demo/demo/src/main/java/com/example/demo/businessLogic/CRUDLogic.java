package com.example.demo.businessLogic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CategoriesDAO;
import com.example.demo.dao.CostsDAO;
import com.example.demo.dao.UsersDAO;
import com.example.demo.dto.CategoriesDTO;
import com.example.demo.dto.CostsDTO;
import com.example.demo.dto.UsersDTO;
import com.example.demo.model.Categories;
import com.example.demo.model.Costs;
import com.example.demo.model.Users;

@Service
public class CRUDLogic {
	@Autowired
	CategoriesDAO categoriesDAO;

	@Autowired
	UsersDAO usersDAO;
	
	@Autowired
	CostsDAO costsDAO;

	public List<CategoriesDTO> getAllCategories() {
		List<CategoriesDTO> listOfAllCategories = new ArrayList<>();
		for (Categories categories : categoriesDAO.findAll()) {
			CategoriesDTO categoriesDTO = new CategoriesDTO(categories);
			listOfAllCategories.add(categoriesDTO);
		}
		return listOfAllCategories;
	}

	public CategoriesDTO getCategoryByName(String name) {
		CategoriesDTO categoriesDTO = new CategoriesDTO(categoriesDAO.findOneByName(name));
		return categoriesDTO;
	}

	public Categories createCategory(CategoriesDTO categoryDTO) {
		Users user = usersDAO.findOneByUsername(categoryDTO.getUserName());
		Categories categories = new Categories();
		categories.setName(categoryDTO.getName());
		categories.setUser(user);

		return categoriesDAO.save(categories);
	}

	public Categories updateCategory(Categories categories) {
		return categoriesDAO.save(categories);
	}

	public void deleteCategory(Categories categories) {
		categoriesDAO.delete(categories);
		;
	}

	public List<UsersDTO> getAllUsers() {
		List<UsersDTO> listOfAllUsers = new ArrayList<>();
		for (Users users : usersDAO.findAll()) {
			UsersDTO usersDTO = new UsersDTO(users);
			listOfAllUsers.add(usersDTO);
		}
		return listOfAllUsers;
	}

	public UsersDTO getUserByUsername(String username) {
		UsersDTO usernameDTO = new UsersDTO(usersDAO.findOneByUsername(username));
		return usernameDTO;
	}

	public Users createUser(UsersDTO usersDTO) {
		Users user = usersDAO.findOneByUsername(usersDTO.getCreatedBy());
		Users users = new Users();
		users.setName(usersDTO.getName());
		users.setUser(user);

		return usersDAO.save(users);
	}

	public Users updateUser(Users users) {
		return usersDAO.save(users);
	}

	public void deleteUser(Users users) {
		usersDAO.delete(users);

	}

	public List<CostsDTO> getAllCosts() {
		List<CostsDTO> listOfAllCosts = new ArrayList<>();
		for (Costs costs : costsDAO.findAll()) {
			CostsDTO costsDTO = new CostsDTO(costs);
			listOfAllCosts.add(costsDTO);
		}
		return listOfAllCosts;
	}

}
