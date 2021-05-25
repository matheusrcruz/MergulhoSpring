package com.easy.easylog.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easy.easylog.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	//Metodos de consulta method query personalizados seguindo o padrão de nomeclatura JPA findBy...
	List<Cliente>findByNome(String nome);
	List<Cliente>findByNomeContaining(String nome);
	Optional<Cliente>findByEmail(String email);

}
