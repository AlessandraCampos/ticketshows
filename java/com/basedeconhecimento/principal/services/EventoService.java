package com.basedeconhecimento.principal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basedeconhecimento.principal.entities.Evento;
import com.basedeconhecimento.principal.repositories.EventoRepository;


@Service
public class EventoService {
	
	@Autowired
	EventoRepository eventoRepository;
	
	public Evento salvarEvento(Evento evento) {
		return eventoRepository.save(evento);
	}
	
	
	public List<Evento> listarEventos(){
		
		return eventoRepository.findAll();
	}
	
	
	
	public Evento buscarEvento (Long id) throws Exception{
		 Optional<Evento> evento = eventoRepository.findById(id);
		 if(evento.isEmpty()) {
			 throw new Exception ("Evento não encontrado");
			 
		 }
		return evento.get();
	}
	
	
   public void excluirEvento (Long id) {
	   eventoRepository.deleteById(id);
   }

}
