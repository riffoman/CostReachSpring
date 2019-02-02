package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.businessLogic.CRUDLogic;
import com.example.demo.dto.CostsDTO;
import com.example.demo.model.Costs;


@RestController
@RequestMapping("/costs")
public class CostsController {

	@Autowired
	CRUDLogic businessLogic;
	
	@GetMapping
	@ResponseBody
	public List<CostsDTO> findAll() {
		return businessLogic.getAllCosts();
	}
	
	@PostMapping
	public Costs createCost(@RequestBody CostsDTO costsDTO) {
		return (businessLogic.createCost(costsDTO));
	}

}
