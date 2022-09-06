package com.jogos.rp.core.port.jogador;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jogos.rp.adapter.input.database.entity.JogadorEntity;
import com.jogos.rp.adapter.input.database.entity.emprego.EmpregoEntity;

import java.math.BigDecimal;
import java.util.List;

public interface JogadorInterface {

    Integer criarJogador(String jogadorModel) throws JsonProcessingException;
    void deletarJogador(JogadorModel jogadorModel);
    List<JogadorEntity> buscarJogadores();
    JogadorEntity buscarJogador(JogadorModel jogadorModel);
    boolean atualizarEmpregoJogador(JogadorModel jogadorModel, Integer idEmprego);

}
