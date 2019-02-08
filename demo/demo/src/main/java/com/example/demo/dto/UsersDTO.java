package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.demo.model.Users;

import lombok.Data;

@Data
public class UsersDTO {
	private Long id;
	private String mail;

	@NotNull
	private String name;

	@NotBlank(message = "polje last name je obavezno")
	private String lastName;

	@NotBlank(message = "polje username je obavezno")
	private String username;
	private String phoneNumber;
	private String address;

	@NotBlank(message = "polje password je obavezno")
	private String password;

	@NotBlank(message = "polje createdBy je obavezno")
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
