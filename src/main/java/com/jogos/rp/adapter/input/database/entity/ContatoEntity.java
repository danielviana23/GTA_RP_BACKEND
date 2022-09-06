package com.jogos.rp.adapter.input.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity(name = "CONTATO")
public class ContatoEntity {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "NUMERO")
    private BigInteger numero;
}
