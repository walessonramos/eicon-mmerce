package br.com.eiconbrasil.ecommerce.domain.repository.filter;

import java.time.OffsetDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class PedidoFiltro {
	
	private Long numeroPedido;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private OffsetDateTime dataCadastro;
	private Long clienteId;
	
	public Long getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(Long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	public OffsetDateTime getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(OffsetDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

}
