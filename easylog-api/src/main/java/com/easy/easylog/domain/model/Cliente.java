package com.easy.easylog.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter //Boriplate Lombok get e set(encap)
@Setter
public class Cliente {
								
	private Long id;
	private String nome;
	private String email;
	private String telefone;
}


