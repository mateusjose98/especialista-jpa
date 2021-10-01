package com.algaworks.ecommerce.relacionamentos;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Categoria;

public class AutoRelacionamentoTest extends EntityManagerTest{

	
	@Test
	public void verificarRelacionamento() {
		
		Categoria categoriaPai = new Categoria();
		categoriaPai.setNome("Eletronicos");
		
		Categoria categoriaFilha = new Categoria();
		categoriaFilha.setNome("Celulares");
		categoriaFilha.setCategoriaPai(categoriaPai);
		
		
		
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(categoriaPai);
		entityManager.persist(categoriaFilha);
		

		entityManager.getTransaction().commit();
		entityManager.clear();
		
		Categoria c = entityManager.find(Categoria.class, categoriaFilha.getId());
		Assert.assertNotNull(c);
		
		
	}
}
