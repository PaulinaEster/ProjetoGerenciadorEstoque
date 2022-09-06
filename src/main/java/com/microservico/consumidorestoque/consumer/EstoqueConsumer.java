package com.microservico.consumidorestoque.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import constantes.RabbitMQConstantes;
import dto.EstoqueDTO;

@Component
public class EstoqueConsumer {
	
	@RabbitListener(queues = RabbitMQConstantes.FILA_ESTOQUE)
	private void consumidor(EstoqueDTO estoqueDTO) {
		System.out.println(estoqueDTO.quantidade + estoqueDTO.codigoProduto + estoqueDTO.getClass()); 
	}
}