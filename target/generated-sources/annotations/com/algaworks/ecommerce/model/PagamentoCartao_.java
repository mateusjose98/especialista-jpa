package com.algaworks.ecommerce.model;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PagamentoCartao.class)
public abstract class PagamentoCartao_ extends com.algaworks.ecommerce.model.Pagamento_ {

	public static volatile SingularAttribute<PagamentoCartao, String> numeroCartao;
	public static volatile SingularAttribute<PagamentoCartao, LocalDate> dataVencimento;

	public static final String NUMERO_CARTAO = "numeroCartao";
	public static final String DATA_VENCIMENTO = "dataVencimento";

}

