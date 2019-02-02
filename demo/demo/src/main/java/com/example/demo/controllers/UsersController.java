package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UsersDAO;
import com.example.demo.model.Users;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UsersDAO usersDAO;



	@GetMapping
	@ResponseBody
	public ArrayList<Users> findAll() {
		return (ArrayList<Users>) usersDAO.findAll();
	}

	@RequestMapping(value = "/{mail}", method = RequestMethod.GET)
	@ResponseBody
	public Users findOne(@PathVariable("mail") String mail) {
		return (usersDAO.findOneByMail(mail));
	}
	
	@PostMapping
	public Users saveUser(@RequestBody Users user) {
		return (usersDAO.save(user));
	}

}
