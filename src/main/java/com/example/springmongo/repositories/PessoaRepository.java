package com.example.springmongo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springmongo.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
