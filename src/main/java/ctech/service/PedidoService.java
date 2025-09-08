package ctech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ctech.dto.PedidoDTO;
import ctech.model.Pedido;
import ctech.messaging.producer.PedidoProducer;
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
        pedido = pedidoRepository.save(pedido);
        pedidoProducer.enviarParaFila(pedido);
        return pedido;
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }
}
