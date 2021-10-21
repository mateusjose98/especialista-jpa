package com.algaworks.ecommerce.mapeamentoavancao;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.NotaFiscal;
import com.algaworks.ecommerce.model.Pedido;

public class SalvarArquivoTest extends EntityManagerTest {

    @Test
    public void salvarItem() {
      Pedido pedido = entityManager.find(Pedido.class, 1L);
      
      NotaFiscal notaFiscal = new NotaFiscal();
      notaFiscal.setDataEmissao(new Date());
      
     
      
      notaFiscal.setXml(null);
      entityManager.getTransaction().begin();
      entityManager.persist(notaFiscal);
      entityManager.getTransaction().commit();
      
      NotaFiscal notaFiscalVeriFiscal = entityManager.find(NotaFiscal.class, notaFiscal.getId());
    }
}
