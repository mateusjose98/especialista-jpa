package com.algaworks.ecommerce.criteria;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.Produto;
import com.algaworks.ecommerce.model.ProdutoDTO;

public class BasicoCriteriaTest extends EntityManagerTest {
	
	
	@Test
	public void projetarResultadoDTO() {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ProdutoDTO> criteria = builder.createQuery(ProdutoDTO.class);

		Root<Produto> root = criteria.from(Produto.class);

		criteria.select(builder.construct(ProdutoDTO.class, root.get("id"), root.get("nome"))
				);

		var typedQuery = entityManager.createQuery(criteria);

		List<ProdutoDTO> lista = typedQuery.getResultList();
		lista.forEach(arr -> {
			System.out.println(arr.getId() + "_" + arr.getNome());
		}

		);

	}
	
	@Test
	public void projetarResultadoTuple() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteria = builder.createTupleQuery();

		Root<Produto> root = criteria.from(Produto.class);

		criteria.select(builder.tuple(root.get("id").alias("id"), root.get("nome").alias("nome")));

		var typedQuery = entityManager.createQuery(criteria);

		List<Tuple> lista = typedQuery.getResultList();
		lista.forEach(arr -> {
			System.out.println(arr.get("id") + "_" + arr.get("nome"));
		}

		);

	}

	@Test
	public void projetarResultado() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);

		Root<Produto> root = criteria.from(Produto.class);

		criteria.multiselect(root.get("id"), root.get("nome"));

		var typedQuery = entityManager.createQuery(criteria);

		List<Object[]> lista = typedQuery.getResultList();
		lista.forEach(arr -> {
//			System.out.println(arr[0] + "_" + arr[1]);
		}

		);

	}

	@Test
	public void buscarTodosPedidos() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Pedido> criteria = builder.createQuery(Pedido.class);
		Root<Pedido> root = criteria.from(Pedido.class);
		criteria.select(root);

		var query = entityManager.createQuery(criteria);

		List<Pedido> pedidos = query.getResultList();

		pedidos.forEach(pedido -> System.out.println(pedido.getId() + " - " + pedido.getStatus()));

	}

	@Test
	public void retornaAtributoSimples() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);

		Root<Pedido> root = cq.from(Pedido.class);

		cq.select(root.get("id")).where(cb.equal(root.get("id"), 1L));

		TypedQuery<Long> typedQuery = entityManager.createQuery(cq);

		Long idRetornado = typedQuery.getSingleResult();

		System.out.println(idRetornado);

	}

	@Test
	public void selecionarUmAtributoRetorno() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Cliente> query = criteriaBuilder.createQuery(Cliente.class);

		Root<Pedido> root = query.from(Pedido.class);

		query.select(root.get("cliente"));

		query.where(criteriaBuilder.equal(root.get("id"), 1L));

		TypedQuery<Cliente> typedQuery = entityManager.createQuery(query);

		Cliente cliente = typedQuery.getSingleResult();

		Assert.assertEquals("Fernando Medeiros", cliente.getNome());

	}

	@Test
	public void buscarPorIdentificador() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Pedido> query = criteriaBuilder.createQuery(Pedido.class);

		Root<Pedido> root = query.from(Pedido.class);

		query.select(root);

		query.where(criteriaBuilder.equal(root.get("id"), 1L));

		TypedQuery<Pedido> typedQuery = entityManager.createQuery(query);

		Pedido pedido = typedQuery.getSingleResult();

		Assert.assertNotNull(pedido);

	}

}
