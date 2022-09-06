package com.jogos.rp.core.port.jogador;

import com.jogos.rp.adapter.input.database.entity.ArmaEntity;
import com.jogos.rp.adapter.input.database.entity.LoginEntity;
import com.jogos.rp.adapter.input.database.entity.ProdutoEntity;
import com.jogos.rp.adapter.input.database.entity.VeiculoEntity;
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
@Builder
@AllArgsConstructor
public class JogadorModel {

    public JogadorModel(){};

    private Integer cpf;
    private String gamertag;
    private String nomeJogador;
    private Integer vida;
    private Integer fome;
    private Integer sede;
    private Integer sono;
    private Integer idControle;
    private String gamerTag;
    private LoginEntity login;
    private List<VeiculoEntity> veiculos;
    private List<ProdutoEntity> produtos;
    private List<ArmaEntity> armas;
    private EmpregoEntity emprego;
    private BigDecimal dinheiro;
    private boolean isJogadorPreso;
    private boolean senha;
}
