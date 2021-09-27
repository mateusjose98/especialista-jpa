package com.algaworks.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.model.Produto;

public class EntityManagerTest {
	
	protected static EntityManagerFactory entityManagerFactory;
	
	protected EntityManager entityManager;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce-PU");
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		
		
		entityManagerFactory.close();

	}
	
	@Before
	public void setUp() {
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	@After
	public void tearDown() {

		entityManager.close();

	}
	

}
