package br.com.eiconbrasil.ecommerce.api.assembler;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eiconbrasil.ecommerce.api.model.input.PedidoInput;
import br.com.eiconbrasil.ecommerce.domain.model.Pedido;

@Component
public class PedidoDTODisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * 
	 * Método para converão de um objeto do tipo PedidoInput.class para um objeto de entidade de domínio do tipo Pedido.class.
	 * 
	 * @param PedidoDTO
	 * @return Pedido
	 * 
	 *  @author Walesson Ramos
	 */
	public Pedido toDomainModel(PedidoInput pedidoInput) {
		return modelMapper.map(pedidoInput, Pedido.class);
	}
	
	/**
	 * 
	 * Método para converão de uma coleção de objetos do tipo PedidoInput.class para uma coleção de objetos de entidade de domínio do tipo Pedido.class.
	 * 
	 * @param PedidoDTO
	 * @return Pedido
	 * 
	 *  @author Walesson Ramos
	 */
	public List<Pedido> toDomainModel(List<PedidoInput> listaPedidoInput) {
		
		List<Pedido> pedidos = new ArrayList<Pedido>();
		
		for(PedidoInput input : listaPedidoInput) {
			pedidos.add(toDomainModel(input));
		}
		return pedidos;
	}

}
