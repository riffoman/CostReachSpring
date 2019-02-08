package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.model.Categories;

import lombok.Data;

@Data
public class CategoriesDTO {
	private Long id;

	@NotEmpty(message = "{error.name.longerThan5}")
	@Size(min = 5, message = "{error.name.longerThan5}")
	private String name;

	@NotNull
	private String userName;

	public CategoriesDTO(Categories category) {
		super();
		this.id = category.getId();
		this.name = category.getName();
		if (category.getUser() != null)
			this.userName = category.getUser().getName();
	}

	public CategoriesDTO() {
	}
}
