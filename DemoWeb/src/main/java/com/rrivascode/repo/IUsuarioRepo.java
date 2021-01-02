 package com.rrivascode.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rrivascode.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{
	
	Usuario findByUsuario(String usuario);

}
