package com.jogos.rp.adapter.input.database.entity;

import com.jogos.rp.adapter.input.database.entity.emprego.EmpregoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity(name = "JOGADOR")
public class JogadorEntity {

    public JogadorEntity(){};

    @Id
    @Column(name = "ID_JOGADOR")
    private UUID idJogador;

    @Column(name = "NICKNAME_JOGADOR")
    private String nicknameJogador;

    @Column(name = "INDICADOR_VIDA")
    private Integer vida;

    @Column(name = "INDICADOR_FOME")
    private Integer fome;

    @Column(name = "INDICADOR_SEDE")
    private Integer sede;

    @Column(name = "INDICADOR_SONO")
    private Integer sono;

    @OneToMany
    private List<VeiculoEntity> veiculos;

    @OneToMany
    private List<ProdutoEntity> produtos;

    @OneToMany
    private List<ArmaEntity> armas;

    @OneToOne
    private EmpregoEntity emprego;

    @Column(name = "DINHEIRO")
    private BigDecimal dinheiro;

    @Column(name = "INDICADOR_JOGADOR_PRESO")
    private boolean isJogadorPreso;

}
