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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "s_kategorija")
@Data
@SequenceGenerator(name = "s_kategorija_seq_gen", sequenceName = "s_kategorija_seq", allocationSize=1)
public class Categories {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_kategorija_seq_gen")
	@Column(name = "id_ska")
	private Long id;

	@Column(nullable = false, unique = true, name = "ska_naziv")
	private String name;

	@ManyToOne
	@JsonIgnore	
	@JoinColumn(name = "id_sko")
	private Users user;
}