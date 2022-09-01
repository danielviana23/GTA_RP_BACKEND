package com.jogos.rp.adapter.input.database.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Builder
@Getter
@Setter
@Entity(name = "DELEGACIA")
public class DelegaciaEntity {

    @Id
    @Column(name = "ID_DELEGACIA")
    private Integer idDelegacia;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "ID_PRISAO")
    private PrisaoEntity prisao;
}
