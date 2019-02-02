package com.example.demo.dto;

import com.example.demo.model.Categories;

import lombok.Data;
@Data
public class CategoriesDTO {
	private Long id;
	private String name;
	private String userName;
	
	public CategoriesDTO(Categories category) {
		super();
		this.id = category.getId();
		this.name = category.getName();
		this.userName = category.getUser().getName();
	}

	public CategoriesDTO() {
	}
}
