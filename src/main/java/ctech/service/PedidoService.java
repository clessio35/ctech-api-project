package ctech.service;

import org.springframework.stereotype.Service;

import ctech.dto.PedidoDTO;
import ctech.model.Pedido;
import ctech.repository.PedidoRepository;

@Service
public class PedidoService {

	private final PedidoRepository pedidoRepository;
	private final PedidoProducer pedidoProducer;
	
	public PedidoService(PedidoRepository pedidoRepository, PedidoProducer pedidoProducer) {
		this.pedidoRepository = pedidoRepository;
		this.pedidoProducer = pedidoProducer;
	}
	
	public Pedido criarPedido(PedidoDTO dto) {
		Pedido pedido = new Pedido();
		pedido.setDescricao(dto.getDescricao());
		pedido.setValor(dto.getValor());
		
		Pedido salvo = pedidoRepository.save(pedido);
		pedidoProducer.enviarParaFila(salvo);
		return salvo;
	}
	
	
}
