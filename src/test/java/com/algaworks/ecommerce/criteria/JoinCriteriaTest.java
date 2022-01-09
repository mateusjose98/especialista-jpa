package com.algaworks.ecommerce.criteria;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.ItemPedido;
import com.algaworks.ecommerce.model.Pagamento;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.Produto;

public class JoinCriteriaTest extends EntityManagerTest {
	
	
	@Test
	public void usarJoinFetch() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Pedido> createQuery = builder.createQuery(Pedido.class);
		var root = createQuery.from(Pedido.class);

		root.fetch("itens", JoinType.LEFT);
		root.fetch("cliente", JoinType.LEFT);
		root.fetch("notaFiscal", JoinType.LEFT);

		createQuery.select(root);
		
		createQuery.where(builder.equal(root.get("id"), 1L));
		
		TypedQuery<Pedido> typedQuery = entityManager.createQuery(createQuery);
		
		Pedido lista = typedQuery.getSingleResult();
		
		
		
		
	}
	
//	@Test
//	public void fazerLeftJoin() {
//		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Pedido> createQuery = builder.createQuery(Pedido.class);
//		var root = createQuery.from(Pedido.class);
//
//		Join<Pedido, Pagamento> joinPagamento = root.join("pagamento", JoinType.LEFT);
//
//		createQuery.select(root);
//		
//		TypedQuery<Pedido> typedQuery = entityManager.createQuery(createQuery);
//		
//		List<Pedido> lista = typedQuery.getResultList();
//		
//		lista.forEach(System.out::println);
//		
//		
//	}
//	
//	@Test
//	public void fazerJoin() {
//		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Pedido> createQuery = builder.createQuery(Pedido.class);
//		var root = createQuery.from(Pedido.class);
//		
//
//		Join<Pedido, Pagamento> joinPagamento = root.join("pagamento");
//		Join<Pedido, ItemPedido> joinItens = root.join("itens");
//		Join<Pedido, Produto> joinitemProduto = joinItens.join("produto");
//		
//		
//		createQuery.select(root);
//		
//		TypedQuery<Pedido> typedQuery = entityManager.createQuery(createQuery);
//		
//		List<Pedido> lista = typedQuery.getResultList();
//		
//		lista.forEach(System.out::println);
//		
//		
//	}

}
