package ctech.messaging.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import ctech.config.RabbitMQConfig;
import ctech.model.Pedido;

@Component
public class PedidoProducer {

	private final RabbitTemplate rabbitTemplate;

	public PedidoProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void enviarParaFila(Pedido pedido) {
		rabbitTemplate.convertAndSend(RabbitMQConfig.NOME_DA_FILA, pedido);
	}
	
}
