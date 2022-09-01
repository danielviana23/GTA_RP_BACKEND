package com.jogos.rp.core.sessao.mock;

import com.jogos.rp.adapter.input.database.entity.JogadorEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JogadorMock {

    public static JogadorEntity criarJogador(UUID idJogador, String nomeJogador) {

        JogadorEntity jogadorEntity = JogadorEntity.builder()
                .idJogador(idJogador)
                .nicknameJogador(nomeJogador)
                .vida(100)
                .isJogadorPreso(false)
        .build();

        return jogadorEntity;
    }
}
