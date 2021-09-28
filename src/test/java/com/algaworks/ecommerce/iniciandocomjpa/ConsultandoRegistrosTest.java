package com.algaworks.ecommerce.iniciandocomjpa;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;

public class ConsultandoRegistrosTest extends EntityManagerTest{
	
	
	@Test
	public void buscarPorIdentificador() {
		
		Produto produto = entityManager.find(Produto.class, 1);
		
//		Produto produto2 = entityManager.getReference(Produto.class, 1); // enquanto não usamos uma propriedade do 'resultado'
																		//  o hibernate não vai no banco
		
//		System.out.println(produto2);
		Assert.assertNotNull(produto);
		
	}
	
	
	@Test
	public void atualizarReferencia() {
		Produto produto = entityManager.find(Produto.class, 1);
		produto.setNome("microfone samsung");
		entityManager.refresh(produto);
		
		Assert.assertEquals("Kindle", produto.getNome());
		
	}
	
	@Test
	public void buscarPorIdentificado2r() {
		
		System.out.println("teste");
		
	}

}
