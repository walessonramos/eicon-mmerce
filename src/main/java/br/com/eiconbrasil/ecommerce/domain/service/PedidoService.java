package br.com.eiconbrasil.ecommerce.domain.service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eiconbrasil.ecommerce.domain.exception.EntidadeNaoEncontradaException;
import br.com.eiconbrasil.ecommerce.domain.model.Cliente;
import br.com.eiconbrasil.ecommerce.domain.model.Pedido;
import br.com.eiconbrasil.ecommerce.domain.repository.ClienteRepository;
import br.com.eiconbrasil.ecommerce.domain.repository.PedidoRepository;
import br.com.eiconbrasil.ecommerce.domain.service.exception.ServicoException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repositorio;
	
	@Autowired
	private ClienteRepository clienteRepositorio;
	
	public Pedido buscarPorNumero(Long id) {
		
		return repositorio.findById(id)
				.orElseThrow(()-> new EntidadeNaoEncontradaException(String.format("Não existe pedido cadastrado para o número %d", id)));
	}
	
	@Transactional
	public List<Pedido> salvar(List<Pedido> listaPedidos){
		
		validaLista(listaPedidos);
		listaPedidos.forEach(this::salvar);
		return listaPedidos;
	}
	
	public Pedido salvar(Pedido pedido) {
		
		if(!validarDuplicidadeNumeroPedido(pedido)) {
			throw new ServicoException(String.format("Já existe pedido cadastrado para o número: %d", pedido.getNumero()));
		}
		
		Optional<Cliente> cliente = clienteRepositorio.findById(pedido.getCliente().getId());
		
		if(cliente.isEmpty()) {
			throw new EntidadeNaoEncontradaException(String.format("Não existe Cliente cadastrado para o código: %d", pedido.getCliente().getId()));
		}
		pedido.setCliente(cliente.get());
		
		aferirPedido(pedido);
		calcularTotalPedido(pedido);
		calcularDesconto(pedido);
		
		return repositorio.save(pedido);
	}
	
	public void aferirPedido(Pedido pedido) {
		if(pedido.getQuantidade() == null || pedido.getQuantidade() == 0) {
			pedido.setQuantidade(1);
		}
		if(pedido.getDataCadastro() == null) {
			pedido.setDataCadastro(OffsetDateTime.now());
		}
	}
	
	public void calcularTotalPedido(Pedido pedido) {
		BigDecimal quantidade = new BigDecimal(pedido.getQuantidade().toString());
		BigDecimal total = pedido.getProduto().getValor().multiply(quantidade);
		pedido.setValorTotal(total);
	}
	
	
	public void calcularDesconto(Pedido pedido){
		
		BigDecimal percentualDesconto = new BigDecimal(getPercentualDesconto(pedido.getQuantidade()).toString());
		BigDecimal cem = new BigDecimal("100");
		
		BigDecimal baseCalculo = cem.subtract(percentualDesconto);
		
		BigDecimal totalComDesconto = baseCalculo.multiply(pedido.getValorTotal()).divide(cem);
		
		pedido.setValorTotal(totalComDesconto);
	}
	
	public Integer getPercentualDesconto(Integer quantidade) {
		
		if(quantidade > 5 && quantidade < 10) {
			return 5;
		}
		if(quantidade >= 10) {
			return 10;
		}
		return 0;
	}
	
	public boolean validarDuplicidadeNumeroPedido(Pedido pedido) {
		
		Optional<Pedido> pedidoExistente = repositorio.findById(pedido.getNumero());
		
		if(pedidoExistente.isPresent()) {
			return false;
		}
		return true;
	}
	
	public void validaLista(List<Pedido> listaPedidos) {
		
		if(listaPedidos == null || listaPedidos.isEmpty() ) {
			throw new ServicoException("A lista de pedidos está vazia.");
		}
		
		if(listaPedidos.size() > 10) {
			throw new ServicoException(String.format("A lista deve conter no máximo 10 pedidos. Total de pedidos enviados: %d", listaPedidos.size()));
		}
	}

}
