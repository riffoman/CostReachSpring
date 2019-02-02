package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.Costs;

@Component
public interface CostsDAO  extends CrudRepository<Costs, Long> {

}
