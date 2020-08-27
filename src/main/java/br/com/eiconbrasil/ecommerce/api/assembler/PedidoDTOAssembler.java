package br.com.eiconbrasil.ecommerce.api.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eiconbrasil.ecommerce.api.model.PedidoDTO;
import br.com.eiconbrasil.ecommerce.domain.model.Pedido;

@Component
public class PedidoDTOAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * Método para conversão de um objeto do tipo Pedido.class para o um objeto do tipo PedidoDTO.class para
	 * a representação dos dados nas respostas das requisições.
	 * 
	 * @param Pedido
	 * @return PedidoDTO
	 * 
	 * @author Walesson Ramos
	 */
	public PedidoDTO toDTO(Pedido pedido) {
		return modelMapper.map(pedido, PedidoDTO.class);
	}
	
	/**
	 * Método para conversão de uma lista de objetos do tipo Pedido.class para o uma lsita de objetos do tipo PedidoDTO.class para
	 * a representação dos dados nas respostas das requisições.
	 * 
	 * @param Pedido
	 * @return PedidoDTO
	 * 
	 * @author Walesson Ramos
	 */
	public List<PedidoDTO> toDTOs(List<Pedido> pedidos) {
		
		List<PedidoDTO> listaDTOs = new ArrayList<PedidoDTO>();
		
		for(Pedido pedido : pedidos) {
			listaDTOs.add(toDTO(pedido));
		}
		return listaDTOs;
	}
	
	/**
	 * Método para conversão de uma coleção de objetos do tipo Pedido.class para uma coleção do tipo PedidoDTO.class.
	 * 
	 * @param listaPedidos
	 * @return List<PedidoDTO> PedidoDTO
	 * 
	 *  @author Walesson Ramos
	 */
	public List<PedidoDTO> toCollectionDTO(List<Pedido> listaPedidos){
		return listaPedidos.stream()
				.map(pedido -> toDTO(pedido))
				.collect(Collectors.toList());
	}

}
