package com.elton.java.back.end.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elton.java.back.end.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByCpf(String cpf);
	
	List<User> findByNomeContainingIgnoreCase(String name);
	
	//List<User> queryByNomeLike(String name);
}




