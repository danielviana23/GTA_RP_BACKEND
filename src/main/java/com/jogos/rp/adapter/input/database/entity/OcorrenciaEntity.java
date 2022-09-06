package com.jogos.rp.adapter.input.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity(name = "OCORRENCIA")
public class OcorrenciaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_OCORRENCIA")
    private Integer id;

    @Column(name = "ID_JOGADOR_OCORRENCIA")
    private Integer idJogadorOcorrencia;

    @Column(name = "ID_NUMERO_OCORRENCIA")
    private BigInteger idNumeroEmergencia;

    @Column(name = "OCORRENCIA")
    private String descricaoOcorrencia;

}
