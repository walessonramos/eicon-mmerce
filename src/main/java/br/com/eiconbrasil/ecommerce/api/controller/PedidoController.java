package br.com.eiconbrasil.ecommerce.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.eiconbrasil.ecommerce.api.assembler.PedidoDTOAssembler;
import br.com.eiconbrasil.ecommerce.api.assembler.PedidoDTODisassembler;
import br.com.eiconbrasil.ecommerce.api.model.PedidoDTO;
import br.com.eiconbrasil.ecommerce.api.model.input.PedidoInput;
import br.com.eiconbrasil.ecommerce.domain.model.Pedido;
import br.com.eiconbrasil.ecommerce.domain.repository.PedidoRepository;
import br.com.eiconbrasil.ecommerce.domain.repository.filter.PedidoFiltro;
import br.com.eiconbrasil.ecommerce.domain.service.PedidoService;
import br.com.eiconbrasil.ecommerce.infraestructure.repository.specs.PedidoSpecs;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Pedidos")
@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoRepository repositorio;
	@Autowired
	private PedidoService service;
	@Autowired
	private PedidoDTOAssembler pedidoAssembler;
	@Autowired
	private PedidoDTODisassembler pedidoDisassembler;
	
	@ApiOperation("Busca os pedidos por filtros")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PedidoDTO> buscarPorFiltro(PedidoFiltro filtro){
		
		return pedidoAssembler.toCollectionDTO(repositorio.findAll(PedidoSpecs.buscarPorFiltro(filtro)));
	}
	
	/**
	 * Busca com retorno em XML customizado.
	 */
//	@ApiOperation("Lista os pedidos em XML")
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public PedidoXml listarEmXml(){
		return new PedidoXml(repositorio.findAll());
	}
	
	@ApiOperation("Busca um pedido por número")
	@GetMapping("/{id}")
	public PedidoDTO buscarPorNumero(@PathVariable Long id) {
		
		Pedido pedido = service.buscarPorNumero(id);
		return pedidoAssembler.toDTO(pedido);
	}
	
	@ApiOperation("Cadastra um novo pedido")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PedidoDTO salvar(@RequestBody @Valid PedidoInput pedidoInput) {
		
			PedidoDTO pedidoDTO = pedidoAssembler.toDTO(service.salvar(pedidoDisassembler.toDomainModel(pedidoInput)));
			return pedidoDTO;
	}
	
	@ApiOperation("Cadastra uma lsita de pedidos")
	@PostMapping("/adicionar-lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<PedidoDTO> salvarLista(@RequestBody @Valid List<PedidoInput> pedidosInput) {
		
		List<PedidoDTO> lsitaDTOs = pedidoAssembler.toDTOs(service.salvar(pedidoDisassembler.toDomainModel(pedidosInput)));
		return lsitaDTOs;
	}
}
