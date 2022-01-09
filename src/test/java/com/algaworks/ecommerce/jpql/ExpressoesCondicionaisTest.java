package com.algaworks.ecommerce.jpql;

import java.util.List;

import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;

public class ExpressoesCondicionaisTest extends EntityManagerTest {

	
	@Test 
	public void usarExpressoesLike() {
		
		
		
		String jpql = "select c from Cliente c where c.nome like concat(:nome, '%') ";
		
		TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
		typedQuery.setParameter("nome", "Fernando");
		
		List<Object[]> lista = typedQuery.getResultList();
		
		System.out.println(lista);
		
		Assert.assertNotNull(lista.isEmpty());
	}
}
