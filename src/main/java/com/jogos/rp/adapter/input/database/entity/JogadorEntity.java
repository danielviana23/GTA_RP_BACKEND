package com.jogos.rp.adapter.input.database.entity;

import com.jogos.rp.adapter.input.database.entity.emprego.EmpregoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity(name = "JOGADOR")
public class JogadorEntity {

    public JogadorEntity(){};

    @Id
    private Integer idControle;

    private Integer cpf;

    @Column(name = "GAMERTAG")
    private String gamerTag;

    @OneToOne(cascade = CascadeType.ALL)
    private LoginEntity login;

    @Column(name = "NOME_PERSONAGEM")
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

    @OneToOne(cascade = CascadeType.ALL)
    private EmpregoEntity emprego;

    @Column(name = "DINHEIRO")
    private BigDecimal dinheiro;

    @Column(name = "INDICADOR_JOGADOR_PRESO")
    private boolean isJogadorPreso;

    @Column(name = "SENHA")
    private boolean senha;

}
