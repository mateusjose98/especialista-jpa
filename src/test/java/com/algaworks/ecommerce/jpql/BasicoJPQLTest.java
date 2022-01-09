package com.algaworks.ecommerce.jpql;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.ProdutoDTO;

public class BasicoJPQLTest extends EntityManagerTest {
	
	
	@Test
	public void projetarDTO() {
		String jpql = "select new com.algaworks.ecommerce.model.ProdutoDTO(id, nome) from Produto";
		TypedQuery<ProdutoDTO> tQuery = entityManager.createQuery(jpql, ProdutoDTO.class);
		
		List<ProdutoDTO> list = tQuery.getResultList();
		System.out.println(list);

		
	}

	@Test
	public void projetarResultado() {
		String jpql = "select id, nome from Produto";

		TypedQuery<Object[]> tQuery = entityManager.createQuery(jpql, Object[].class);

		List<Object[]> list = tQuery.getResultList();

		list.forEach(item -> {
			System.out.println(item[0] + ", " + item[1]);
		});

		Assert.assertTrue(list.get(0).length == 2);

	}

	@Test
	public void buscarPorIdentificador() {
		// entityManager.find(Pedido.class, 1)

		TypedQuery<Pedido> typedQuery = entityManager.createQuery("select p from Pedido p where p.id = 1",
				Pedido.class);

		Pedido pedido = typedQuery.getSingleResult();
		Assert.assertNotNull(pedido);

//        List<Pedido> lista = typedQuery.getResultList();
//        Assert.assertFalse(lista.isEmpty());
	}

	@Test
	public void mostrarDiferencaQueries() {
		String jpql = "select p from Pedido p where p.id = 1";

		TypedQuery<Pedido> typedQuery = entityManager.createQuery(jpql, Pedido.class);
		Pedido pedido1 = typedQuery.getSingleResult();
		Assert.assertNotNull(pedido1);

		Query query = entityManager.createQuery(jpql);
		Pedido pedido2 = (Pedido) query.getSingleResult();
		Assert.assertNotNull(pedido2);

//        List<Pedido> lista = query.getResultList();
//        Assert.assertFalse(lista.isEmpty());
	}

}
