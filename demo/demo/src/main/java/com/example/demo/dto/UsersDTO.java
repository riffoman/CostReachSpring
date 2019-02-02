package com.example.demo.dto;

import com.example.demo.model.Users;

import lombok.Data;

@Data
public class UsersDTO {
	private Long id;
	private String mail;
	private String name;
	private String lastName;
	private String username;
	private String phoneNumber;
	private String address;
	private String password;
	private String createdBy;
	
	public UsersDTO(Users users) {
		super();
		this.mail = users.getMail();
		this.name = users.getName();
		this.lastName = users.getLastName();
		this.username = users.getUsername();
		this.phoneNumber = users.getPhoneNumber();
		this.address = users.getAddress();
		this.password = users.getPassword();
		this.createdBy = users.getUser().getName();
	}

	private UsersDTO() {
		super();
	}
}
