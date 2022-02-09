package com.algaworks.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pedido.class)
public abstract class Pedido_ extends com.algaworks.ecommerce.model.EntidadeBaseInteger_ {

	public static volatile SingularAttribute<Pedido, Cliente> cliente;
	public static volatile ListAttribute<Pedido, ItemPedido> itens;
	public static volatile SingularAttribute<Pedido, BigDecimal> total;
	public static volatile SingularAttribute<Pedido, EnderecoEntregaPedido> enderecoEntrega;
	public static volatile SingularAttribute<Pedido, LocalDateTime> dataConclusao;
	public static volatile SingularAttribute<Pedido, LocalDateTime> dataUltimaAtualizacao;
	public static volatile SingularAttribute<Pedido, NotaFiscal> notaFiscal;
	public static volatile SingularAttribute<Pedido, Pagamento> pagamento;
	public static volatile SingularAttribute<Pedido, LocalDateTime> dataCriacao;
	public static volatile SingularAttribute<Pedido, StatusPedido> status;

	public static final String CLIENTE = "cliente";
	public static final String ITENS = "itens";
	public static final String TOTAL = "total";
	public static final String ENDERECO_ENTREGA = "enderecoEntrega";
	public static final String DATA_CONCLUSAO = "dataConclusao";
	public static final String DATA_ULTIMA_ATUALIZACAO = "dataUltimaAtualizacao";
	public static final String NOTA_FISCAL = "notaFiscal";
	public static final String PAGAMENTO = "pagamento";
	public static final String DATA_CRIACAO = "dataCriacao";
	public static final String STATUS = "status";

}

