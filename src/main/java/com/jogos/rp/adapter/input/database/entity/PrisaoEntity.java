package com.jogos.rp.adapter.input.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity(name = "PRISAO")
public class PrisaoEntity {

    @Id
    @Column(name = "ID_PRISAO")
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JogadorEntity> jogadoresPresos;
}
