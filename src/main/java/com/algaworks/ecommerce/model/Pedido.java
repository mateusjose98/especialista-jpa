package com.algaworks.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity @Table(name = "pedido")
public class Pedido {

    @EqualsAndHashCode.Include
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne(optional = false) @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    @Column(name = "data_conclusao")
    private LocalDateTime dataConclusao;

    @Column(name = "nota_fiscal")
    private Integer notaFiscalId;

    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    
    @Embedded
    private EnderecoEntregaPedido enderecoEntrega;
    
    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
    List<ItemPedido> itensPedido;
    
    @OneToOne(mappedBy ="pedido")
    private PagamentoCartao pagamento;
    
    @OneToOne(mappedBy ="pedido")
    private NotaFiscal notaFiscal;
    
}
