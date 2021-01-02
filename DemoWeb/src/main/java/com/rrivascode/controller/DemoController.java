package com.rrivascode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rrivascode.model.Persona;
import com.rrivascode.model.Transporte;
import com.rrivascode.repo.IPersonaRepo;
import com.rrivascode.repo.ITransporteRepo;

@Controller
public class DemoController {
	
	@Autowired
	private IPersonaRepo repoP;
	@Autowired
	private ITransporteRepo repoT;
	

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model, 
							@RequestParam(name="x", required=false) String x,
							@RequestParam(name="namespace", required=false, defaultValue="RichValens")String ns ) {
		model.addAttribute("name", name);
		model.addAttribute("x", x);
		model.addAttribute("namespace", ns);
		
		
		Persona p = new Persona();
		p.setIdPersona(2);
		p.setNombre("rrivasApp");
		repoP.save(p);
		
		
		Transporte t = new Transporte();
		t.setId(1);
		t.setTransporte("Bicicleta");
		t.setDescripcion("Transporte Personal de Propulsión Humana.");
		repoT.save(t);
		t.setId(2);
		t.setTransporte("Automovil");
		t.setDescripcion("Transporte Personal Autopropulsado.");
		t.setId(3);
		t.setTransporte("Ferrocarril");
		t.setDescripcion("Transporte Publico Motorizado");
		
		repoT.save(t);
		System.out.println("Repositorio T Agregado");
			
		
		return "greeting";
	}
	
	@GetMapping("/listar")
	public String greeting(Model model) {
		//logica 
		
		model.addAttribute("registro", repoP.findAll());
		
		model.addAttribute("transporte", repoT.findAll());
		
		return "greeting";
	}
	
}


/*
@PostMapping("/api/foos")
@ResponseBody
public String addFoo(@RequestParam(name = "id") String fooId, @RequestParam String name) { 
    return "ID: " + fooId + " Name: " + name;
}*/