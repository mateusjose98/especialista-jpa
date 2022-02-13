package com.algaworks.ecommerce.concorrencia;



import com.algaworks.ecommerce.model.Produto;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class LockOtimistaTest {


    protected static EntityManagerFactory entityManagerFactory;

    @BeforeClass
    public static void setupBeforeClass(){
        entityManagerFactory = Persistence
                .createEntityManagerFactory("Ecommerce-PU");

    }

    @AfterClass
    public static void tearDownAfterClass() {entityManagerFactory.close();}

    private static void log(Object obj, Object... args){
        System.out.println(
                String.format(" LOG [ " + System.currentTimeMillis() + " ]" + obj, args)
        );
    }


    private static void esperar(int segundos){
        try{
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e){

        }
    }


    @Test
    public void usarLockOtimista() {
        Runnable runnable1 = () -> {
            EntityManager entityManager1 = entityManagerFactory.createEntityManager();
            entityManager1.getTransaction().begin();

            log("Runnable 01 vai carregar o produto 1.");
            Produto produto = entityManager1.find(Produto.class, 1);

            log("Runnable 01 vai esperar por 3 segundos.");
            esperar(3);
            String user1 = "[Runnable 01] Descri��o detalhada.";
            log("Runnable 01 vai alterar o produto.");
            produto.setDescricao(user1);

            log("Runnable 01 vai confirmar a transa��o.");
            try {
                entityManager1.getTransaction().commit();
                entityManager1.close();
            }catch (RollbackException ex){
                log("Erro ao deletar ou atualizar o registro " + 1 + "a entidade est� em uso em outra transa��o.");
            }

        };

        Runnable runnable2 = () -> {
            EntityManager entityManager2 = entityManagerFactory.createEntityManager();
            entityManager2.getTransaction().begin();

            log("Runnable 02 vai carregar o produto 1.");
            Produto produto = entityManager2.find(Produto.class, 1);

            log("Runnable 02 vai esperar por 1 segundo.");
            esperar(1);

            log("Runnable 02 vai alterar o produto.");
            String user2 = "[Runnable 02] Descri��o massa!";
            produto.setDescricao(user2);

            log("Runnable 02 vai confirmar a transa��o.");
            entityManager2.getTransaction().commit();
            entityManager2.close();
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        EntityManager entityManager3 = entityManagerFactory.createEntityManager();
        Produto produto = entityManager3.find(Produto.class, 1);
        entityManager3.close();

        Assert.assertEquals("[Runnable 02] Descri��o massa!", produto.getDescricao());

        log("Encerrando m�todo de teste.");
    }



}
