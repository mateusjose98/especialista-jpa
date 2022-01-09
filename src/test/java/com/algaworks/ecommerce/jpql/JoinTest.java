package com.algaworks.ecommerce.jpql;

import java.util.List;

import javax.persistence.TypedQuery;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Pedido;

public class JoinTest extends EntityManagerTest {
	
	
	@Test
	public void buscarPedidosComProduto1() {
		String jpql = "select i.pedido from ItemPedido i "
				+ " where i.produto.id = 1 "; 
		
		TypedQuery<Pedido> r = entityManager.createQuery(jpql, Pedido.class);
		List<Pedido> list = r.getResultList();
		
		list.forEach(item -> System.out.println(item.getId()));
				

	}
	
	
	@Test
	public void fazerJoinFetch() {
		String jpql = 
				" select p from Pedido p "
				+ " left join fetch p.itens "
				+ " where p.id = 1 ";
		TypedQuery<Pedido> tQuery = entityManager
				.createQuery(jpql, Pedido.class);
		
		List<Pedido> list = tQuery.getResultList();
		System.out.println(list);

	}
	
	@Test
	public void fazerJoin() {
		String jpql = 
				"select p, pag from Pedido p "
				+ "join p.pagamento pag";
		TypedQuery<Object[]> tQuery = entityManager.createQuery(jpql, Object[].class);
		
		List<Object[]> list = tQuery.getResultList();
		System.out.println(list);

	}

}
