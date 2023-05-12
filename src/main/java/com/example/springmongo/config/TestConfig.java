package com.example.springmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.springmongo.entities.Pessoa;
import com.example.springmongo.entities.Pokemon;
import com.example.springmongo.entities.Type;
import com.example.springmongo.repositories.PessoaRepository;
import com.example.springmongo.repositories.PokemonRepository;
import com.example.springmongo.repositories.TypeRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private TypeRepository typeRepository;
	
	@Autowired
	private PokemonRepository pokemonRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Pessoa p1 = new Pessoa(null, "Carlin");
		Pessoa p2 = new Pessoa(null, "Jorjin");
		
		pessoaRepository.saveAll(Arrays.asList(p1, p2));
		
		Type t1 = new Type(null, "Grass", "Green");
		Type t2 = new Type(null, "Water", "Blue");
		Type t3 = new Type(null, "Fire", "Red");
		Type t4 = new Type(null, "normal", "white");
		
		typeRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
		
		Pokemon pk1 = new Pokemon(null, "Pikaku", "Pikatiu!");
		pk1.getTypes().add(t2);
		pk1.getTypes().add(t4);

		
		pokemonRepository.saveAll(Arrays.asList(pk1));
		
	}
}
