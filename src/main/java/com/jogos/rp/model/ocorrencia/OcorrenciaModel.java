package com.jogos.rp.model.ocorrencia;

import com.jogos.rp.core.port.jogador.JogadorModel;
import lombok.*;

import java.math.BigInteger;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class OcorrenciaModel {

    public OcorrenciaModel(){}

    private Integer cpfJogadorOcorrencia;
    private BigInteger numeroChamado;
    private String descricaoOcorrencia;

}
