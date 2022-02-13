package com.algaworks.ecommerce.concorrencia;

/*
*
* Concorr�ncia -> disputa pela permiss�o de atualizar um registro.
* Imagine duas pessoas que possuem uma conta conjunta (Maria e Jo�o)
* Maria foi em uma agencia A e Jo�o foi em outra B e na conta h� R$ 100,00
*
* Maria precisa sacar R$ 40 e o faz, assim, na realidade h� R$ 60
* (o correto seria dar um LOCK no registro para jo�o n�o atualizar, otimista ou pessimista)
* Jo�o ainda est� vendo os R$ 100 e saca R$ 10 - achando que ficaria R$ 90
*
*
* */


import org.junit.Test;

public class ThreadTest {

    private static void log(Object obj, Object... args){
        System.out.println(
                String.format("[LOG " + System.currentTimeMillis() + " ]" + obj, args)
        );
    }

    private static void esperar(int segundos){
        try{
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e){

        }
    }

    @Test
    public void entenderThreads(){
        Runnable runnable1 = () -> {
            log("Runnable 1 vai esperar 3 segundos");
            esperar(3);
            log("Runnable 1 conclu�da");
        };

        Runnable runnable2 = () -> {
            log("Runnable 2 vai esperar 1 segundos");
            esperar(1);
            log("Runnable 2 conclu�da");
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        log("Encerrando m�todo de teste.");

    }



}
