package ctech.messaging.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import ctech.config.RabbitMQConfig;
import ctech.model.Pedido;

@Component
public class PedidoConsumer {

	@RabbitListener(queues = RabbitMQConfig.NOME_DA_FILA)
	public void processar(Pedido pedido) {
		System.out.println("Pedido recebido da fila: " + pedido.getDescricao());
	}
}
