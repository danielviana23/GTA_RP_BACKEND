package com.jogos.rp.model.enums;

import lombok.Getter;

@Getter
public enum EnumStatusJogadorSessao {
    ONLINE(1),
    OFFLINE(0);

    private Integer valorStatusJogador;
    private EnumStatusJogadorSessao(Integer status_atual_jogador_sessao) {
        this.valorStatusJogador = status_atual_jogador_sessao;
    }
}
