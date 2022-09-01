package com.jogos.rp.adapter.input.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.ws.BindingType;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity(name = "SESSAO_ATIVA")
public class SessaoEntity {

    public SessaoEntity() {}

    @Id
    @Column(name = "ID_SESSAO")
    private Integer idSessao;

    @OneToMany
    private List<JogadorEntity> jogadores;
}
