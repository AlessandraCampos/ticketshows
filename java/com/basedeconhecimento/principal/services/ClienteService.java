package com.basedeconhecimento.principal.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.basedeconhecimento.principal.entities.Cliente;
import com.basedeconhecimento.principal.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public List<Cliente> listarCliente() {

		return clienteRepository.findAll();

	}
	
	

	public Cliente salvarCliente(Cliente cliente) {

		return clienteRepository.save(cliente);
	}

	
	
	public Cliente buscarCliente(Long id) throws Exception {
		
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		if (cliente.isEmpty()) {
			
			throw new Exception("Cliente não encontrado");

		}
		return cliente.get();
	}
	
	

	public void excluirCliente(Long id) {

		clienteRepository.deleteById(id);
	}

}
