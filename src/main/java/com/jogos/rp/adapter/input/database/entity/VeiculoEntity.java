package com.jogos.rp.adapter.input.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity(name = "VEICULO")
public class VeiculoEntity {

    public VeiculoEntity() {}

    @Id
    @Column(name = "ID_VEICULO")
    private Integer idVeiculo;

    @Column(name = "PRECO_VEICULO")
    private BigDecimal precoVeiculo;

    @Column(name = "PATH_IMAGEM_VEICULO")
    private BigDecimal pathImagemVeiculo;

}
