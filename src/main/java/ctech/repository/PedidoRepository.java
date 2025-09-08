package ctech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ctech.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
 
}
