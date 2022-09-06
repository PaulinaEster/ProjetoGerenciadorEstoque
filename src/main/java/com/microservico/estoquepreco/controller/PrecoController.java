package com.microservico.estoquepreco.controller;

import constantes.RabbitMQConstantes;
import dto.PrecoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.microservico.estoquepreco.service.RabbitmqService;

@RequestMapping(value = "preco")
@RestController
public class PrecoController {
	
	@Autowired
	private RabbitmqService rabbitmqService;
	
	@PutMapping
	private ResponseEntity<String> alteraPreco(@RequestBody PrecoDTO preco){
		this.rabbitmqService.enviaMensagem(RabbitMQConstantes.FILA_PRECO, preco);
		return ResponseEntity.ok().body(""+preco.codigoProduto+ " atualizado com sucesso.");
	}
	
}
