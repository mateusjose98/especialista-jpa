package com.algaworks.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter @ToString
@DiscriminatorValue("cartao")
@Entity
public class PagamentoCartao extends Pagamento {

    @Column(name = "numero_cartao")
    private String numeroCartao;
}
