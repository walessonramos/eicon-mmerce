package br.com.eiconbrasil.ecommerce.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class PedidoDTO {
	
	private Long numero;
	private OffsetDateTime dataCadastro;
	private Integer quantidade;
	private ClienteDTO cliente;
	private ProdutoDTO produto;
	private BigDecimal valorTotal;
	
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public OffsetDateTime getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(OffsetDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public ProdutoDTO getProduto() {
		return produto;
	}
	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
