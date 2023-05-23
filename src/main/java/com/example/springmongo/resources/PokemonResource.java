package com.example.springmongo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Pokemon> insert(@RequestBody Pokemon obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pokemon> findById(@PathVariable Long id){
		Pokemon obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Pokemon> update(@PathVariable Long id, @RequestBody Pokemon pokemon){
		pokemon = service.update(id, pokemon);
		return ResponseEntity.ok().body(pokemon);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
		
}
