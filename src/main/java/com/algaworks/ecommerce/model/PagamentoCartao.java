package com.algaworks.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@DiscriminatorValue("cartao")
@Entity
public class PagamentoCartao extends Pagamento {

    @Column(name = "numero_cartao", length = 50)
    private String numeroCartao;


    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;
}
