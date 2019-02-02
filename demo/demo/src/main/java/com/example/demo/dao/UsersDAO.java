package com.example.demo.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.Users;

@Component
public interface UsersDAO extends CrudRepository<Users, Long> {

	public Users findOneByMailAndPassword(String mail, String password);

	public Users findOneByMail(String mail);
	
	public Users save(Users persisted);

	public Users findOneByUsername(String username);

}