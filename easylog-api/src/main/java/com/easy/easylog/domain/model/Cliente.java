package com.easy.easylog.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter //Boriplate Lombok get e set(encap)
@Setter
@Entity
public class Cliente {
	
	@EqualsAndHashCode.Include //Equals and hashCode
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String email;
	
	@Column(name ="fone")
	private String telefone;
}


