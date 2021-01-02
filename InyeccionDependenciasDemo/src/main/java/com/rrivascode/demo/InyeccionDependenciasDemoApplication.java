package com.rrivascode.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class InyeccionDependenciasDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(InyeccionDependenciasDemoApplication.class, args);
		Customers c = context.getBean(Customers.class);	
		
		c.display();
	
	}
	
	

}
