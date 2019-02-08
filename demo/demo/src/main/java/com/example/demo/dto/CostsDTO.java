package com.example.demo.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import com.example.demo.model.Costs;

import lombok.Data;

@Data
public class CostsDTO {
	private Long id;
	private String description;
	private Timestamp date;

	@NotNull
	private BigDecimal price;

	@NotNull
	private String category;

	@NotNull
	private String createdBy;

	public CostsDTO(Costs costs) {
		super();
		this.id = costs.getId();
		this.description = costs.getDescription();
		this.date = costs.getDate();
		this.price = costs.getPrice();
		this.category = costs.getCategory().getName();
		this.createdBy = costs.getUser().getUsername();
		this.setDate(new Timestamp(System.currentTimeMillis()));
	}
}
