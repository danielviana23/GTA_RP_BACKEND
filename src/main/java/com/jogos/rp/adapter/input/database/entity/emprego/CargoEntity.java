package com.jogos.rp.adapter.input.database.entity.emprego;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.naming.Name;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "PARAMETRIZACAO_CARGO")
public class CargoEntity {

    @Id
    @Column(name = "ID_GARGO")
    private Integer id;

    @Column(name = "DESCRICAO_CARGO")
    private String descricaoCargo;
}
