package br.com.eiconbrasil.ecommerce.api.model.input;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class PedidoInput {
	
	@NotNull
	private Long numero;
	
	@NotNull
	@Valid
	private ClienteIdInput clienteId;
	
	@NotNull
	@Valid
	private ProdutoIdInput produtoId;
	
	private OffsetDateTime dataCadastro;
	
	private Integer quantidade;
	
	private BigDecimal valorTotal;

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public ClienteIdInput getClienteId() {
		return clienteId;
	}

	public void setClienteId(ClienteIdInput clienteId) {
		this.clienteId = clienteId;
	}

	public ProdutoIdInput getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(ProdutoIdInput produtoId) {
		this.produtoId = produtoId;
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

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
