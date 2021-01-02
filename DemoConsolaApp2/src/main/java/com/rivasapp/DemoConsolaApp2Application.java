package com.rivasapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoConsolaApp2Application implements CommandLineRunner {
	
	private static Logger LOG = LoggerFactory.getLogger(DemoConsolaApp2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoConsolaApp2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("Hola Camaradas de Spring Consola!");
		LOG.info("'Mensaje desde la Consola de Spring Boot!'");
	}

}
