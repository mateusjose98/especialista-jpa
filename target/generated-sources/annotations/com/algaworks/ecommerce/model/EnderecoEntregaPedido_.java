package com.algaworks.ecommerce.model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EnderecoEntregaPedido.class)
public abstract class EnderecoEntregaPedido_ {

	public static volatile SingularAttribute<EnderecoEntregaPedido, String> cidade;
	public static volatile SingularAttribute<EnderecoEntregaPedido, String> estado;
	public static volatile SingularAttribute<EnderecoEntregaPedido, String> complemento;
	public static volatile SingularAttribute<EnderecoEntregaPedido, String> numero;
	public static volatile SingularAttribute<EnderecoEntregaPedido, String> logradouro;
	public static volatile SingularAttribute<EnderecoEntregaPedido, String> bairro;
	public static volatile SingularAttribute<EnderecoEntregaPedido, String> cep;

	public static final String CIDADE = "cidade";
	public static final String ESTADO = "estado";
	public static final String COMPLEMENTO = "complemento";
	public static final String NUMERO = "numero";
	public static final String LOGRADOURO = "logradouro";
	public static final String BAIRRO = "bairro";
	public static final String CEP = "cep";

}

