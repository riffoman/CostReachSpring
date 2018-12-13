package com.example.demo.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UsersDAO;
import com.example.demo.model.Users;

@RestController
@RequestMapping("/usersController")
public class UsersController {

	@Autowired
	UsersDAO usersDAO;



	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Users> findAll() {
		return (ArrayList<Users>) usersDAO.findAll();
	}

	@RequestMapping(value = "/{mail}", method = RequestMethod.GET)
	@ResponseBody
	public Users findOne(@PathVariable("mail") String mail) {
		return (usersDAO.findOneByMail(mail));
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Users saveUser(@RequestBody Users persisted) {
		return (usersDAO.save(persisted));
	}

}
