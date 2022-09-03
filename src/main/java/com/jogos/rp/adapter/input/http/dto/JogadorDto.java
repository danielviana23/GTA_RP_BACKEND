package com.jogos.rp.adapter.input.http.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class JogadorDto {

    public JogadorDto(){}
    private String gamertag;
    private String nome_personagem;
    private String email;
    private String senha;
}