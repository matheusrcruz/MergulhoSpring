package com.easy.easylog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easy.easylog.domain.model.Cliente;
import com.easy.easylog.domain.repository.ClienteRepository;
import com.easy.easylog.domain.service.exception.ServiceExcption;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogoCliente {
	
	private ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if (emailEmUso) {
			throw new ServiceExcption("Já existe um cliente cadastrado com este e-mail.");
		}
		
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
	
	
}
