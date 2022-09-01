package com.jogos.rp.adapter.input.database.entity.emprego;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@Entity(name = "EMPREGO")
public class EmpregoEntity {

    public EmpregoEntity(){}

    @Id
    @Column(name = "ID_EMPREGO")
    private Integer id;

    @Column(name = "NOME")
    private String nomeEmprego;

    @OneToOne
    private CargoEntity cargo;

    @Column(name = "SALARIO")
    private BigDecimal salario;


}
