package com.algaworks.ecommerce.model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Estoque.class)
public abstract class Estoque_ extends com.algaworks.ecommerce.model.EntidadeBaseInteger_ {

	public static volatile SingularAttribute<Estoque, Produto> produto;
	public static volatile SingularAttribute<Estoque, Integer> quantidade;

	public static final String PRODUTO = "produto";
	public static final String QUANTIDADE = "quantidade";

}

