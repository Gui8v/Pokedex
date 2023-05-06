package com.example.springmongo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springmongo.entities.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {

}
