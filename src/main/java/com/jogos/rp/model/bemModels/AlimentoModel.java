package com.jogos.rp.model.bemModels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class AlimentoModel {

    private String nome;
    private Integer saciedade;
    private BigDecimal preco;
}
