package com.jogos.rp.adapter.input.http.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class JogadorTransferencia {

    public JogadorTransferencia(){}

    private String id_jogador;
    private BigDecimal dinheiro;

}
