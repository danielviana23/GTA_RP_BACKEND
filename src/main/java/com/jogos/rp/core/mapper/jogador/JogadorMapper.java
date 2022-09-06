package com.jogos.rp.core.mapper.jogador;

import com.jogos.rp.adapter.input.database.entity.JogadorEntity;
import com.jogos.rp.core.port.jogador.JogadorModel;

public class JogadorMapper {

    public JogadorEntity jogadorModelToEntity(JogadorModel model) {
        JogadorEntity jogadorEntity = JogadorEntity.builder()
                .idControle(model.getIdControle())
                .cpf(model.getCpf())
                .gamerTag(model.getGamertag())
                .login(model.getLogin())
                .nomeJogador(model.getNomeJogador())
                .vida(model.getVida())
                .fome(model.getFome())
                .sede(model.getSede())
                .sono(model.getSono())
                .veiculos(model.getVeiculos())
                .produtos(model.getProdutos())
                .armas(model.getArmas())
                .emprego(model.getEmprego())
                .dinheiro(model.getDinheiro())
                .isJogadorPreso(model.isJogadorPreso())
        .build();

        return jogadorEntity;
    }

}
