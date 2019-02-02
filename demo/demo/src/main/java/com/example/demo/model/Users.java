package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "s_korisnik")
@Data
@SequenceGenerator(name = "s_korisnik_seq_gen", sequenceName = "s_korisnik_seq", allocationSize=1)
public class Users {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_korisnik_seq_gen")
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
}
