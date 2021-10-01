package com.algaworks.ecommerce.relacionamentos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.ItemPedido;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.Produto;
import com.algaworks.ecommerce.model.StatusPedido;

public class RelacionamentoOneToOneTest extends EntityManagerTest{

	
	@Test
	public void verificarRelacionamento() {
		
		entityManager.getTransaction().begin();
		
		entityManager.getTransaction().commit();
		entityManager.clear();
		
		
		
	}
}
