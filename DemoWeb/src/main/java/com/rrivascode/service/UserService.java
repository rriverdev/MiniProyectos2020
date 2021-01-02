package com.rrivascode.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rrivascode.model.Usuario;
import com.rrivascode.repo.IUsuarioRepo;


@Service
public class UserService implements UserDetailsService{

	@Autowired
	private IUsuarioRepo repoUs;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			Usuario us = repoUs.findByUsuario(username);
			
			List<GrantedAuthority> roles = new ArrayList<>();
			roles.add( new SimpleGrantedAuthority("ADMIN"));
			
			UserDetails userDet = new User(us.getUsuario(), us.getPassword(), roles);
			
		return userDet;
		
	}

}
