 package com.rrivascode.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rrivascode.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer>{
	

}
