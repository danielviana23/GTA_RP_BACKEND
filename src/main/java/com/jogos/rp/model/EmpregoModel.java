package com.jogos.rp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class EmpregoModel {

    private String nome;
    private BigDecimal salario;
    private Integer cargaHoraria;

}
