package com.algaworks.ecommerce.mapeamentobasico;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.SexoCliente;

public class MapeandoEnumeracoesTest extends EntityManagerTest{

	@Test
	public void testarEnum() {
		Cliente cliente = new Cliente();
		cliente.setId(4);
		cliente.setNome("José");
		cliente.setSexo(SexoCliente.MASCULINO);
		
		entityManager.getTransaction().begin();
		
		
		entityManager.persist(cliente);
		
		
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Cliente clienteRecuperado = entityManager.find(Cliente.class, 4);
		Assert.assertNotNull(clienteRecuperado);
		
		
	}
}
