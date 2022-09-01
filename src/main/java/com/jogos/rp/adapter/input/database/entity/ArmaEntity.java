package com.jogos.rp.adapter.input.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity(name = "ARMA")
public class ArmaEntity {

    public ArmaEntity() {}

    @Id
    @Column(name = "ID_ARMA", unique = true)
    private Integer idArma;

    @Column(name = "NOME_ARMA")
    private String nomeArma;

    @Column(name = "PRECO_ARMA")
    private BigDecimal preco;

    @Column(name = "REGISTRO_ARMA")
    private String registro;
}
