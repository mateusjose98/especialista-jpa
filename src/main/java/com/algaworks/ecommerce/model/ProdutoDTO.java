package com.algaworks.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class ProdutoDTO {
	
	private Integer id;
	private String nome;

}
