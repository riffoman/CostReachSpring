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
import javax.persistence.Table;
@Entity
@Table(name = "s_troskovi")
public class Costs {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_str")
	private Long id;
	
	@Column(name = "str_opis")
	private String description;

	@Column(name = "str_datum")
	private Timestamp date;
	
	@Column(name = "str_cijena")
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name = "id_ska",nullable=false)
	private Categories category;

	@ManyToOne
	@JoinColumn(name = "id_sko", nullable=false)
	private Users user;
	
	public Costs(String description, Timestamp date, BigDecimal price, Categories category,Users user) {
		super();
		this.description = description;
		this.date=date;
		this.price=price;
		this.category=category;
		this.user = user;
	}

	public Costs() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
}