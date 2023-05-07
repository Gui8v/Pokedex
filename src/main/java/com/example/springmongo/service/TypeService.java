package com.example.springmongo.service;

import java.util.List;
import java.util.Optional;

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
	
	public Type findById(long id) {
		Optional<Type> obj = repository.findById(id);
			return obj.get();
	}
	
	public Type insert(Type obj) {
		return repository.save(obj);
	}
}
