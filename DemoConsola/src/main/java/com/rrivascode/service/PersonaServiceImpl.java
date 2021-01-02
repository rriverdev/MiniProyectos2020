package com.rrivascode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rrivascode.repository.IPersonaRepo;

@Service		// estereotipo que representa una logica e negocio es @Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired //estereotipo encargado de buscar una instncia definida por un estereotipo, aqui buscara la implementacion de IPersonaRepo 
	@Qualifier("Uno")
	private IPersonaRepo repo;
	
	@Override
	public void registrar(String nombre) {
//		repo = new PersonaRepoImpl();		// mientras exista la anotacion @Service no es necesario instanciar repo a a clase PersonaRepoImpl
		repo.registrar(nombre);
	}

}
