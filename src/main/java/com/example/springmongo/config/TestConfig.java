package com.example.springmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.springmongo.entities.Pessoa;
import com.example.springmongo.repositories.PessoaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Pessoa p1 = new Pessoa(null, "Carlin");
		Pessoa p2 = new Pessoa(null, "Jorjin");
		
		pessoaRepository.saveAll(Arrays.asList(p1, p2));
	}
}
