package com.rrivascode;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rrivascode.model.Usuario;
import com.rrivascode.repo.IUsuarioRepo;

@SpringBootTest
class DemoWebApplicationTests {

	@Autowired
	private IUsuarioRepo repoU;
	
	@Autowired
	private BCryptPasswordEncoder crypt; 
	
	@Test
	public void generaUsuarioTest() {
		Usuario us = new Usuario();
//		us.setId(3);
//		us.setUsuario("valenz");
//		us.setPassword(crypt.encode("100"));
		us.setId(4);
		us.setUsuario("user000");
		us.setPassword(crypt.encode("000"));
		repoU.save(us);
		Usuario usReturn = repoU.save(us);
////		assertTrue
//		
		assertTrue(usReturn.getPassword().equalsIgnoreCase(us.getPassword()));
//		
	}



}
