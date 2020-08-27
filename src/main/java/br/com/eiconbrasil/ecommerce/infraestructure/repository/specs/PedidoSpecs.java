package br.com.eiconbrasil.ecommerce.infraestructure.repository.specs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import br.com.eiconbrasil.ecommerce.domain.model.Pedido;
import br.com.eiconbrasil.ecommerce.domain.repository.filter.PedidoFiltro;

public class PedidoSpecs {
	
	public static Specification<Pedido> porCliente(Long clienteId){
		return (root, query, builder) -> 
			builder.equal(root.get("cliente"), clienteId);
	}
	
	public static Specification<Pedido> porData(Date dataCadastro){
		
		return (root, query, builder) -> 
			builder.equal(root.get("dataCadastro"), dataCadastro);
	}
	
	public static Specification<Pedido> porNumero(Long numero){
		
		return (root, query, builder) -> 
			builder.equal(root.get("numero"), numero);
	}
	
	public static Specification<Pedido> buscarPorFiltro(PedidoFiltro filtro){
		
		return (root, query, builder) -> {
			
			root.fetch("cliente");
			root.fetch("produto");
			
			List<Predicate> predicates = new ArrayList<Predicate>();
			
			if(filtro.getNumeroPedido() != null) {
				predicates.add(builder.equal(root.get("numero"), filtro.getNumeroPedido()));
			}
			
			if(filtro.getClienteId() != null) {
				predicates.add(builder.equal(root.get("cliente"), filtro.getClienteId()));
			}
			
			if(filtro.getDataCadastro() != null) {
				predicates.add(builder.greaterThanOrEqualTo(root.get("dataCadastro"), filtro.getDataCadastro()));
			}
			
			return builder.and(predicates.toArray(new Predicate[0]));
			
		};
	}

}
