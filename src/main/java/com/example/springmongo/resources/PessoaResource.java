package com.example.springmongo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springmongo.entities.Pessoa;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {
	
	@GetMapping
	public ResponseEntity<Pessoa> findAll(){
		Pessoa p = new Pessoa(1l, "Champson");
		return ResponseEntity.ok().body(p);
	}
	
}
