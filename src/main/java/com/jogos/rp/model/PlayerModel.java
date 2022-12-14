package com.jogos.rp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jogos.rp.model.enums.EnumStatusJogador;
import com.jogos.rp.model.enums.EnumStatusJogadorSessao;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerModel {

    // TODO ADICIONAR VALIDADOR
    private String gamertag;
    private String nickname;
    private Integer vida;
    private NecessidadesModel necessidades;
    private List<EmpregoModel> emprego;
    private List<BemModel> bens;
    private EnumStatusJogador status_jogador;
    private EnumStatusJogadorSessao status_jogador_sessao;

    public void matarOutroJogador(String id_jogador_assassinado) {

    }

}