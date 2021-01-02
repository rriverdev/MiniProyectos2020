package com.rrivascode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rrivascode.service.IPersonaService;

@SpringBootApplication
public class DemoConsolaApplication implements CommandLineRunner{

	private static Logger LOG = LoggerFactory.getLogger(DemoConsolaApplication.class);
	@Autowired 		// sirve para traer una instncia definida por un stereotipo o definicion de bean en el proyecto
	private IPersonaService service;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoConsolaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Hola Coders");
//		LOG.info("Hola com.rrivasCode");
//		LOG.warn("Warning Codders");
//		service = new PersonaServiceImpl();
		service.registrar("richValens");
		
	}
	
	

}
