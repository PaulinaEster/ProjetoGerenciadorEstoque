package com.microservico.estoquepreco.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RabbitmqService {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private ObjectMapper mapper;
	
	public void enviaMensagem(String nomeFila, Object mensagem) {
		
		try {
			String mensagemJson = this.mapper.writeValueAsString(mensagem);
			this.rabbitTemplate.convertAndSend(nomeFila, mensagemJson);
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		
	}

}
