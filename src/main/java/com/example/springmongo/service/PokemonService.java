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
	
	public Pokemon update(long id, Pokemon 	pokemon) {
		Pokemon entity = repository.getReferenceById(id);
		updateData(entity, pokemon);
		return repository.save(entity);
	}

	private void updateData(Pokemon entity, Pokemon pokemon) {
		entity.setName(pokemon.getName());
		entity.setDescription(pokemon.getDescription());
		entity.setTypes(pokemon.getTypes());
	}	
}
