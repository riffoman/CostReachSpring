package com.example.demo.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

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
@Table(name = "s_troskovi")
@Data
@SequenceGenerator(name = "s_troskovi_seq_gen", sequenceName = "s_troskovi_seq", allocationSize = 1)

public class Costs {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_troskovi_seq_gen")
	@Column(name = "id_str")
	private Long id;

	@Column(name = "str_opis")
	private String description;

	@Column(name = "str_datum")
	private Timestamp date;

	@Column(name = "str_cijena")
	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name = "id_ska", nullable = false)
	private Categories category;

	@ManyToOne
	@JoinColumn(name = "id_sko", nullable = false)
	private Users user;

	public Costs(String description, Timestamp date, BigDecimal price, Categories category, Users user) {
		super();
		this.description = description;
		this.date = date;
		this.price = price;
		this.category = category;
		this.user = user;
	}

	public Costs() {
		super();
	}
}