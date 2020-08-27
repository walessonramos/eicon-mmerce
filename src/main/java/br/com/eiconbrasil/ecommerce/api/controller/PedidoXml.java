package br.com.eiconbrasil.ecommerce.api.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import br.com.eiconbrasil.ecommerce.domain.model.Pedido;

/**
 * Classe para representação do recurso em XML.
 * 
 * @author Walesson Ramos
 */

@JacksonXmlRootElement(localName = "pedidos")
public class PedidoXml {
	
	@JsonProperty("pedido")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Pedido> listaPedidos;
	
	public PedidoXml(List<Pedido> listaPedidos) {
		super();
		this.listaPedidos = listaPedidos;
	}

	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

}
