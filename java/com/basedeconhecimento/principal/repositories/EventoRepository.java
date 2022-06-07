package com.basedeconhecimento.principal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basedeconhecimento.principal.entities.Evento;

public interface EventoRepository extends JpaRepository <Evento,Long> {
	
	@Override
	List<Evento> findAll();

}
