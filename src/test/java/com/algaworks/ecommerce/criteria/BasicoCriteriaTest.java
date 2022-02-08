package com.algaworks.ecommerce.criteria;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.dto.ProdutoDTO;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;

public class BasicoCriteriaTest extends EntityManagerTest {

    @Test
    public void projetarOResultadoDTO(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<ProdutoDTO> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(ProdutoDTO.class);

        Root<Produto> root = criteriaQuery.from(Produto.class);

        criteriaQuery.select(criteriaBuilder.construct(ProdutoDTO.class, root.get("id"), root.get("nome")));

        TypedQuery<ProdutoDTO> typedQuery = entityManager.createQuery(criteriaQuery);

        List<ProdutoDTO> resultado = typedQuery.getResultList();

        System.out.println(resultado);


    }

    @Test
    public void projetarOResultadoTuple() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
        Root<Produto> root = criteriaQuery.from(Produto.class);

        criteriaQuery.select(criteriaBuilder
                .tuple(root.get("id").alias("id"), root.get("nome").alias("nome")));

        TypedQuery<Tuple> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Tuple> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());

        lista.forEach(t -> System.out.println("ID: " + t.get("id") + ", Nome: " + t.get("nome")));
    }

    @Test
    public void projetarOResultado() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Produto> root = criteriaQuery.from(Produto.class);

        criteriaQuery.multiselect(root.get("id"), root.get("nome"));

        TypedQuery<Object[]> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Object[]> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());

        lista.forEach(arr -> System.out.println("ID: " + arr[0] + ", Nome: " + arr[1]));
    }

    @Test
    public void retornarTodosOsProdutosExercicio() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> criteriaQuery = criteriaBuilder.createQuery(Produto.class);
        Root<Produto> root = criteriaQuery.from(Produto.class);

        criteriaQuery.select(root);

        TypedQuery<Produto> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Produto> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());
    }

    @Test
    public void selecionarUmAtributoParaRetorno() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BigDecimal> criteriaQuery = criteriaBuilder.createQuery(BigDecimal.class);
        Root<Pedido> root = criteriaQuery.from(Pedido.class);

        criteriaQuery.select(root.get("total"));

        criteriaQuery.where(criteriaBuilder.equal(root.get("id"), 1));

        TypedQuery<BigDecimal> typedQuery = entityManager.createQuery(criteriaQuery);

        BigDecimal total = typedQuery.getSingleResult();

        System.out.println("Total pedido:" + total);

        Assert.assertEquals(new BigDecimal("2398.00"), total);
    }

    @Test
    public void buscarPorIdentificador() {

        //String jpql = "select p from Pedido p where p.id = 1";

        // Auxilia na montagem da query
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        // Cl�usulas - select, multiselect, where, group by, order by ...
        // me diz o tipo do resultado esperado
        CriteriaQuery<Pedido> criteriaQuery = criteriaBuilder.createQuery(Pedido.class);

        // a entidade Raiz da consulta
        Root<Pedido> root = criteriaQuery.from(Pedido.class);

        // opcional pois o retorno = root
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), 1));

        TypedQuery<Pedido> typedQuery = entityManager
                .createQuery(criteriaQuery);

        Pedido pedido = typedQuery.getSingleResult();

        System.out.println(pedido.getId() + " - " + pedido.getStatus());
        Assert.assertNotNull(pedido);
    }
}
