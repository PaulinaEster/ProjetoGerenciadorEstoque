package com.microservico.estoquepreco.controller;
import constantes.RabbitMQConstantes;
import dto.EstoqueDTO; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservico.estoquepreco.service.RabbitmqService; 

@RestController
@RequestMapping(value = "estoque")
public class EstoqueController {
	
	@Autowired
	private RabbitmqService rabbitmqService;
	
	@PutMapping
	private ResponseEntity<String> alteraEstoque(@RequestBody EstoqueDTO estoque){
		this.rabbitmqService.enviaMensagem(RabbitMQConstantes.FILA_ESTOQUE , estoque);
		return ResponseEntity.ok().body(""+estoque.codigoProduto+" atualizado com sucesso.");
	}
	
}
