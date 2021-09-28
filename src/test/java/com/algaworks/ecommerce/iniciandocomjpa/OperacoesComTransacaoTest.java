package com.algaworks.ecommerce.iniciandocomjpa;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;

public class OperacoesComTransacaoTest extends EntityManagerTest {

	
	@Test
	public void mostrarDiferencaPersistMerge() {

		Produto produtoPersist = new Produto();
		produtoPersist.setId(5);
		produtoPersist.setDescricao("Celular do mundo!!!!");
		produtoPersist.setNome("Celular");
		produtoPersist.setPreco(new BigDecimal(7050.0));


		entityManager.getTransaction().begin();

		entityManager.persist(produtoPersist); // em memória temos o próprio obj
		produtoPersist.setNome("nome estranho para persist");

		entityManager.getTransaction().commit();

		entityManager.clear();

		Produto produtoVerificacaoPersist = entityManager.find(Produto.class, 5);
		Assert.assertNotNull(produtoVerificacaoPersist);
		
		// ----------------
		
		Produto produtoMerge = new Produto();
		produtoMerge.setId(6);
		produtoMerge.setDescricao("Notebook do mundo!!!!");
		produtoMerge.setNome("Notebook");
		produtoMerge.setPreco(new BigDecimal(10050.0));


		entityManager.getTransaction().begin();

		produtoMerge = entityManager.merge(produtoMerge); // cria uma cópia e retorna ela
		produtoMerge.setNome("nome estranho para merge");

		entityManager.getTransaction().commit();

		entityManager.clear();

		Produto produtoVerificacaoMerge = entityManager.find(Produto.class, 6);
		Assert.assertNotNull(produtoVerificacaoMerge);

	}
	
	@Test
	public void inserirObjetoComMerge() {

		Produto produto = new Produto();
		produto.setId(4);
		produto.setDescricao("A melhor Impressora do mundo!!!!");
		produto.setNome("Impressora HP");
		produto.setPreco(new BigDecimal(750.0));


		entityManager.getTransaction().begin();

		entityManager.merge(produto);

		entityManager.getTransaction().commit();

		entityManager.clear();

		Produto produtoVerificacao = entityManager.find(Produto.class, 2);
		Assert.assertNotNull(produtoVerificacao);

	}
	
	
	@Test
	public void atualizarObjetoGerenciado() {
		
		Produto produto = entityManager.find(Produto.class, 1);


		produto.setNome("Nome Maluco");
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
		Assert.assertNotNull(produtoVerificacao);
		Assert.assertEquals("Nome Maluco", produtoVerificacao.getNome()); 
		
	}

	
	
	
	@Test
	public void atualizarObjeto() {
		
		Produto produto = new Produto();
		
		produto.setId(1);
		produto.setNome("Chinelo de dedo");
		produto.setDescricao("Sandalia de dedo");
		produto.setPreco(new BigDecimal(10.00));


		entityManager.getTransaction().begin();
		entityManager.merge(produto);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
		Assert.assertNotNull(produtoVerificacao);
		Assert.assertEquals("Chinelo de dedo", produtoVerificacao.getNome());

	}

	@Test
	public void removerObjeto() {

		Produto entity = entityManager.find(Produto.class, 3);
		entity.setId(3);

		entityManager.getTransaction().begin();

		entityManager.remove(entity);

		entityManager.getTransaction().commit();

		Produto produtoVerificacao = entityManager.find(Produto.class, 3);
		Assert.assertNull(produtoVerificacao);

	}

	@Test
	public void inserirOPrimeiroObjeto() {

		Produto produto = new Produto();
		produto.setId(2);
		produto.setDescricao("A melhor camera do mundo!!!!");
		produto.setNome("Canon");
		produto.setPreco(new BigDecimal(1050.0));

		// o perist funcionaria antes também, pois deixa o objeto aguardando em memória
		// até que uma transação seja feita

		entityManager.getTransaction().begin();

		entityManager.persist(produto);

		entityManager.getTransaction().commit();

		entityManager.clear();

		Produto produtoVerificacao = entityManager.find(Produto.class, 2);
		Assert.assertNotNull(produtoVerificacao);

	}

	@Test
	public void abrirEFecharATransacao() {

		entityManager.getTransaction().begin(); // inicio da transação

		// OPERAÇÕES QUE MUDAM O ESTADO DO BANCO

		/*
		 * entityManager.persist(entity); entityManager.merge(entity);
		 * entityManager.remove(entity);
		 */

		entityManager.getTransaction().commit(); // salvando mudanças

	}

}
