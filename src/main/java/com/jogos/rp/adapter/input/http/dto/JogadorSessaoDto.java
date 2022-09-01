package com.jogos.rp.adapter.input.http.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class JogadorSessaoDto {

    public JogadorSessaoDto() {}
    private String id_jogador;
    private Integer id_sessao;
}
