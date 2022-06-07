package com.basedeconhecimento.principal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basedeconhecimento.principal.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente,Long> {
	
	@Override
	List<Cliente>findAll();

}
