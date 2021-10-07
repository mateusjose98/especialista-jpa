package com.algaworks.ecommerce.mapeamentobasico;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.EnderecoEntregaPedido;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.StatusPedido;

public class MapeandoObjetoEmbutido extends EntityManagerTest{

	@Test
	public void analisarMapeamento() {
		
		EnderecoEntregaPedido end = new EnderecoEntregaPedido();
		end.setCep("123123-00");
		end.setBairro("turu");
		end.setCidade("São Luís");
		end.setEstado("MA");
		end.setLogradouro("rua a");
		end.setNumero("202-A");
		
		Pedido p = new Pedido();
		p.setId(1);
//		p.setDataPedido(LocalDateTime.now());
		p.setStatus(StatusPedido.AGUARDANDO);
		p.setTotal(new BigDecimal(100));
		p.setEnderecoEntrega(end);
		

		entityManager.getTransaction().begin();
		
		
		entityManager.persist(p);
		
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		
		

		
		
	}
}
