package com.example.springmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springmongo.service.TypeService;
import com.example.springmongo.entities.Type;

@RestController
@RequestMapping(value = "/types")
public class TypeResource {
	
	@Autowired
	private TypeService service;
	
	@GetMapping
	public ResponseEntity<List<Type>> findAll(){
		List<Type> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
