package com.example.springmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springmongo.entities.Pokemon;
import com.example.springmongo.repositories.PokemonRepository;

@Service
public class PokemonService {
	
	@Autowired
	private PokemonRepository repository;
	
	public List<Pokemon> findAll(){	
		return repository.findAll();
	}
	
	public Pokemon findById(long id) {
		Optional<Pokemon> obj = repository.findById(id);
			return obj.get();
	}
	
	public Pokemon insert(Pokemon obj) {
		return repository.save(obj);
	}
}
