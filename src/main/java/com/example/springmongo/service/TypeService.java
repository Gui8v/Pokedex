package com.example.springmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springmongo.entities.Type;
import com.example.springmongo.repositories.TypeRepository;

@Service
public class TypeService {
	
	@Autowired
	private TypeRepository repository;
	
	public List<Type> findAll(){
		
		return repository.findAll();
	}
}
