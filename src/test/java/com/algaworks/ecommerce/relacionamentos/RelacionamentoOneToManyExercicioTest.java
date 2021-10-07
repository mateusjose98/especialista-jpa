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

public class RelacionamentoOneToManyExercicioTest extends EntityManagerTest{

	
	@Test
	public void verificarRelacionamento() {
		Cliente cliente = entityManager.find(Cliente.class, 1);
		
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
//		pedido.setDataPedido(LocalDateTime.now());
		pedido.setStatus(StatusPedido.AGUARDANDO);
		pedido.setTotal(new BigDecimal(10));
		
		Produto p =  entityManager.find(Produto.class, 1);
		
		ItemPedido item = new ItemPedido();
//		item.setPedido(pedido);
//		item.setPrecoProduto(BigDecimal.TEN);
//		item.setQuantidade(10);
//		item.setProduto(p);
//		
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(pedido);
		entityManager.persist(item);
		
		entityManager.getTransaction().commit();
		entityManager.clear();
		
		Pedido pedidoBanco = entityManager.find(Pedido.class, 1);
		
		
		
		System.out.println(pedidoBanco.getItens());
		
		Assert.assertFalse(pedidoBanco.getItens().isEmpty());
	}
}
