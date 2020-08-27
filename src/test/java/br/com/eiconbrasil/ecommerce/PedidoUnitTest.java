package br.com.eiconbrasil.ecommerce;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.OffsetDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.eiconbrasil.ecommerce.domain.model.Cliente;
import br.com.eiconbrasil.ecommerce.domain.model.Pedido;
import br.com.eiconbrasil.ecommerce.domain.model.Produto;
import br.com.eiconbrasil.ecommerce.domain.service.PedidoService;

/**
 * 
 * Testes unitários para o cadastro de um pedido
 * 
 * @author walesson
 */

@SpringBootTest
public class PedidoUnitTest {
	
	@Autowired
	private PedidoService service;
	
	@Test
	public void deveConfirmarQueOPedidoNaoEValido() {
		Cliente cliente = new Cliente();
		cliente.setId(Long.valueOf("2"));
		
		Produto produto = new Produto();
		produto.setId(Long.valueOf("3"));
		
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setProduto(produto);
		
		pedido.setDataCadastro(OffsetDateTime.now());
		pedido.setQuantidade(2);
		pedido.setNumero(Long.valueOf(2));
		boolean pedidoValido = service.validarDuplicidadeNumeroPedido(pedido);
		
		assertThat(pedidoValido).isFalse();
		
	}

}
