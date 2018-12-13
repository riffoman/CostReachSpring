package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "s_korisnik")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_sko")
	private Long id;

	@Column(nullable = false, unique = true, name = "sko_email")
	private String mail;

	@Column(nullable = false, name = "sko_ime")
	private String name;

	@Column(nullable = false, name = "sko_prezime")
	private String lastName;

	@Column(nullable = false, unique = true, name = "sko_username")
	private String username;

	@Column(nullable = false, name = "sko_tel")
	private String phoneNumber;

	@Column(nullable = false, name = "sko_adresa")
	private String address;

	@Column(nullable = false, name = "sko_password")
	private String password;

	@ManyToOne
	@JoinColumn(name = "id_sko_sko")
	private Users user;

	public Users() {
		super();
	}

	public Users(String mail, String name, String lastName, String username, String phoneNumber, String address,
			String password) {
		super();
		this.mail = mail;
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
