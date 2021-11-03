package com.algaworks.ecommerce.jpql;

import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Pedido;

public class BasicoJPQL extends EntityManagerTest {

	
	@Test // Java Persistence Query Language
	public void buscarPorIdentificador() {
		
		// entityManager.find(Pedido.class, 1);
		
		TypedQuery<Pedido> queryTipada =
				entityManager
				.createQuery("select p from Pedido p where p.id = 1", Pedido.class);
		Pedido p = queryTipada.getSingleResult();
		
		Assert.assertNotNull(p);
	}
}
