package com.example.springmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springmongo.entities.Pokemon;
import com.example.springmongo.service.PokemonService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/pokemons")
public class PokemonResource {
	
	@Autowired
	private PokemonService service;
	
	@GetMapping
	public ResponseEntity<List<Pokemon>> findAll(){
		List<Pokemon> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
