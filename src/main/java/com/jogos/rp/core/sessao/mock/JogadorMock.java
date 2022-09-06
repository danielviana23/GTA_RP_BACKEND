package com.jogos.rp.core.sessao.mock;

import com.jogos.rp.adapter.input.database.entity.JogadorEntity;

public class JogadorMock {

    public static JogadorEntity criarJogador(Integer cpf, Integer idControle, String nickname) {


        JogadorEntity jogadorEntity = JogadorEntity.builder()
                .cpf(cpf)
                .idControle(idControle)
                .nomeJogador(nickname)
                .vida(100)
                .isJogadorPreso(false)
        .build();

        return jogadorEntity;
    }
}
