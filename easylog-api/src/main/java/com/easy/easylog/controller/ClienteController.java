package com.easy.easylog.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easy.easylog.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente>Listar(){
	    Cliente cliente1 = new Cliente();
	    cliente1.setNome("Singed");
		cliente1.setId(1L);
		cliente1.setTelefone("40028922");
		cliente1.setEmail("singed@venenoso.com");
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Ivern");
		cliente2.setId(2L);
		cliente2.setTelefone("707070707");
		cliente2.setEmail("Ivern@floresta.com");
		
		return Arrays.asList(cliente1, cliente2);  //Retorna Lista cliente1 e cliente2
	}

}
