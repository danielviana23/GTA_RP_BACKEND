package com.jogos.rp.adapter.input.http.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class JogadorEmpregoDto {

    public JogadorEmpregoDto() {};
    private String id_jogador;
    private Integer id_emprego;

}