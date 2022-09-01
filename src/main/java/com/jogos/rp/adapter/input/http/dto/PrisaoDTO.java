package com.jogos.rp.adapter.input.http.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PrisaoDTO {

    public PrisaoDTO(){}

    private Integer idJogadorPolicial;
    private Integer idJogadorPreso;
    private Integer tempoDePrisao;

}
