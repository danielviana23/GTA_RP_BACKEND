package com.jogos.rp.model.enums;

import lombok.Getter;

@Getter
public enum EnumStatusJogador {
    VIVO(1),
    MORTO(0);

    private Integer valorStatusJogador;
    private EnumStatusJogador(Integer status_atual_jogador) {
        this.valorStatusJogador = status_atual_jogador;
    }

}
