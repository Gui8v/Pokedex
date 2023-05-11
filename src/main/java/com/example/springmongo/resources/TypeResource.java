package com.example.springmongo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springmongo.entities.Type;
import com.example.springmongo.service.TypeService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/types")
public class TypeResource {
	
	@Autowired
	private TypeService service;
	
	@GetMapping
	public ResponseEntity<List<Type>> findAll(){
		List<Type> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Type> findById(@PathVariable Long id){
		Type obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	} 
	
	@PostMapping
	public ResponseEntity<Type> insert(@RequestBody Type obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
}
		