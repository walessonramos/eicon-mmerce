package br.com.eiconbrasil.ecommerce.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "T_PEDIDO")
public class Pedido implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "T_PEDIDO_ID")
	private Long numero;
	
	@Column(name = "T_PEDIDO_DATA")
	private OffsetDateTime dataCadastro;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "T_PRODUTO_ID")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "T_CLIENTE_ID")
	private Cliente cliente;
	
	@NotNull
	@Column(name = "T_PEDIDO_QTD")
	private Integer quantidade;
	
	@Column(name = "T_PEDIDO_VALOR_TOTAL")
	private BigDecimal valorTotal;

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numeroPedido) {
		this.numero = numeroPedido;
	}

	public OffsetDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(OffsetDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public void setValorTotal(BigDecimal valorTotalPedido) {
		this.valorTotal = valorTotalPedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

}
