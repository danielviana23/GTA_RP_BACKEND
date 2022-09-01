package com.jogos.rp.adapter.input.http.dto;

import com.jogos.rp.adapter.input.database.entity.JogadorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TransferenciaDto {

    public TransferenciaDto(){}

    private JogadorTransferencia jogador1;
    private JogadorTransferencia jogador2;

}
