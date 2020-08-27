package br.com.eiconbrasil.ecommerce.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eiconbrasil.ecommerce.domain.model.Cliente;
import br.com.eiconbrasil.ecommerce.domain.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repositorio;
	
	public Cliente salvar(Cliente cliente) {
		return repositorio.save(cliente);
	}

}
