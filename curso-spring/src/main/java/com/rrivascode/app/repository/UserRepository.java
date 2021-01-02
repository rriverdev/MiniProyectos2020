package com.rrivascode.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rrivascode.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {  
	

}
