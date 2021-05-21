package com.easy.easylog.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter //Boriplate Lombok get e set(encap)
@Setter
@Entity
public class Cliente {
	
	@EqualsAndHashCode.Include //Equals and hashCode compara objeto e compara por identificação
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 60)
	private String nome;
	
	@NotBlank
	@Email
	@Size(max = 255)
	private String email;
	
	@NotBlank
	@Size(max = 20)
	@Column(name ="fone")
	private String telefone;
}


