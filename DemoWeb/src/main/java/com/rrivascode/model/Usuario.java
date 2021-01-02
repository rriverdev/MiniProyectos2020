package com.rrivascode.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Usuario {


	@Id
	private int Id;
	
	private String usuario;
	
	private String password;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
				
	

}
