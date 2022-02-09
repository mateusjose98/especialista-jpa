package com.algaworks.ecommerce.model;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ extends com.algaworks.ecommerce.model.EntidadeBaseInteger_ {

	public static volatile MapAttribute<Cliente, String, String> contatos;
	public static volatile SingularAttribute<Cliente, String> cpf;
	public static volatile SingularAttribute<Cliente, String> nome;
	public static volatile ListAttribute<Cliente, Pedido> pedidos;
	public static volatile SingularAttribute<Cliente, SexoCliente> sexo;
	public static volatile SingularAttribute<Cliente, LocalDate> dataNascimento;

	public static final String CONTATOS = "contatos";
	public static final String CPF = "cpf";
	public static final String NOME = "nome";
	public static final String PEDIDOS = "pedidos";
	public static final String SEXO = "sexo";
	public static final String DATA_NASCIMENTO = "dataNascimento";

}

