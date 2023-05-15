package com.example.springmongo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springmongo.entities.Pokemon;
import com.example.springmongo.entities.Type;
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
	
	@PostMapping
	public ResponseEntity<Pokemon> insert(@RequestBody Pokemon obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
