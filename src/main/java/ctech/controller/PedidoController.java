package ctech.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ctech.dto.PedidoDTO;
import ctech.model.Pedido;
import ctech.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

	private final PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@PostMapping
	public ResponseEntity<Pedido> criar(@RequestBody PedidoDTO dto) {
		Pedido pedido = pedidoService.criarPedido(dto);
		return ResponseEntity.ok(pedido);
	}

	@GetMapping
    public ResponseEntity<List<Pedido>> listarTodos() {
        List<Pedido> pedidos = pedidoService.listarPedidos();
        return ResponseEntity.ok(pedidos);
    }
	
	 @GetMapping("/{id}")
	    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
	        Pedido pedido = pedidoService.buscarPorId(id);
	        if (pedido != null) {
	            return ResponseEntity.ok(pedido);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

}
