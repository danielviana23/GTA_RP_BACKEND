package com.jogos.rp.adapter.input.database.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "VEICULO")
public class VeiculoEntity {

    public VeiculoEntity() {}

    @Id
    @Column(name = "ID_VEICULO")
    private Integer idVeiculo;

    @Column(name = "NOME")
    private Integer nomeVeiculo;

    @Column(name = "PLACA")
    private String placa;

    @Column(name = "PRECO_VEICULO")
    private BigDecimal precoVeiculo;

    @Column(name = "PATH_IMAGEM_VEICULO")
    private BigDecimal pathImagemVeiculo;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProdutoEntity> produtosNoCarro;

}
