package com.jogos.rp.adapter.input.http.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class MensagemRetornoDto {

    public MensagemRetornoDto(){}

    private String mensagemRetorno;
}
