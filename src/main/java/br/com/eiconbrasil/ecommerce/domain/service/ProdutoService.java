package br.com.eiconbrasil.ecommerce.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eiconbrasil.ecommerce.domain.model.Produto;
import br.com.eiconbrasil.ecommerce.domain.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repositorio;
	
	public Produto salvar(Produto produto) {
		return repositorio.save(produto);
	}

}
