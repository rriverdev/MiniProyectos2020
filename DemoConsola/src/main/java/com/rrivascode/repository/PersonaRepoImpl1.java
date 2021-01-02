package com.rrivascode.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.rrivascode.DemoConsolaApplication;

@Repository // este estereotipo indica que se accesa a datos ( informacion )
@Qualifier("Uno")
public class PersonaRepoImpl1 implements IPersonaRepo{

	private static Logger LOG = LoggerFactory.getLogger(DemoConsolaApplication.class);

	
	@Override
	public void registrar(String nombre) {
		// TODO Auto-generated method stub
		LOG.info("Se Registro a:  " + nombre + ">>>> Qualifire Uno");
	}
	
	

}
