package com.rrivascode.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rrivascode.repo.IPersonaRepo;
import com.rrivascode.model.Persona;

@RestController
@RequestMapping("/persona")
public class RestDemoController {

	@Autowired
	private IPersonaRepo repoP;
	
	@GetMapping
	public List<Persona> listar(){
		return repoP.findAll();
	}
	@PostMapping
	public void insertar(@RequestBody Persona obj){
		repoP.save(obj);
	}

	@PutMapping
	public void modificar(@RequestBody Persona obj){
		repoP.save(obj);
	}
	
	@DeleteMapping(value = "/{idPersona}")
	public void eliminar(@PathVariable("idPersona") Integer idPersona){
		repoP.deleteById(idPersona);
	}
	
	
	
	
}
