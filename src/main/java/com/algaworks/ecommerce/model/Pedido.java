package com.algaworks.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    
//    @Column(name = "cliente_id")
//    private Integer clienteId;

    @ManyToOne @JoinColumn(name = "cliente_id")
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
}
