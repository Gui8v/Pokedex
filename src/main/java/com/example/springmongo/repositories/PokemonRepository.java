package com.example.springmongo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springmongo.entities.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

}
