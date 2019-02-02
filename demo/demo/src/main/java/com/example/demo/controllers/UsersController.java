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
import com.example.demo.dto.UsersDTO;
import com.example.demo.model.Users;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	CRUDLogic businessLogic;

	@GetMapping
	@ResponseBody
	public List<UsersDTO> findAll() {
		return businessLogic.getAllUsers();
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	@ResponseBody
	public UsersDTO findOneByUsername(@PathVariable("username") String username) {
		return businessLogic.getUserByUsername(username);
	}

	@PostMapping
	public Users createUser(@RequestBody UsersDTO userDTO) {
		return (businessLogic.createUser(userDTO));
	}
	
	@PutMapping
	public Users updateUser(@RequestBody Users users) {
		return (businessLogic.updateUser(users));
	}
	
	@DeleteMapping
	public void deleteUser(@RequestBody Users users) {
		businessLogic.deleteUser(users);
	}

}
