package com.easy.easylog.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easy.easylog.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@PersistenceContext //injeção de dependencia
	private EntityManager manager;
	
	@GetMapping("/clientes")
	public List<Cliente>Listar(){
		return manager.createQuery("from Cliente", Cliente.class)
				.getResultList();
	   
	}

}
