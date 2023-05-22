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
		
		Pokemon pk1 = new Pokemon(null, "bulbasaur", "There is a plant seed on its back right from the day this Pokémon is born. The seed slowly grows larger.");
		pk1.getTypes().add(t1);
		
		Pokemon pk2 = new Pokemon(null, "squirtle", "When it retracts its long neck into its shell, it squirts out water with vigorous force.");
		pk2.getTypes().add(t2);
		
		Pokemon pk3 = new Pokemon(null, "charmander", "It has a preference for hot things. When it rains, steam is said to spout from the tip of its tail.");
		pk3.getTypes().addAll(Arrays.asList(t1, t2, t3));
	
		pokemonRepository.saveAll(Arrays.asList(pk1, pk2, pk3));
		
	}
}
