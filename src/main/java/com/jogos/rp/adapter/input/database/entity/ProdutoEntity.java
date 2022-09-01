package com.jogos.rp.adapter.input.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity(name = "PRODUTO")
public class ProdutoEntity {

    private ProdutoEntity(){}

    @Id
    @Column(name = "ID_PRODUTO")
    private Integer idProduto;

    @Column(name = "NOME_PRODUTO", unique = true)
    private String nomeProduto;

    @Column(name = "PRECO_PRODUTO", unique = true)
    private BigDecimal precoProduto;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CategoriaProdutoEntity categoriaProduto;

}
