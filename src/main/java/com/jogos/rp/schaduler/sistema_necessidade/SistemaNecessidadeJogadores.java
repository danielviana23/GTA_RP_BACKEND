package com.jogos.rp.schaduler.sistema_necessidade;

import com.jogos.rp.adapter.input.database.entity.SessaoEntity;
import com.jogos.rp.adapter.input.database.repository.jogador.JogadorRepository;
import com.jogos.rp.adapter.input.database.repository.jogador.sessao.SessaoRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SistemaNecessidadeJogadores {

    private JogadorRepository jogadorRepository;
    private SessaoRepository sessaoRepository;

    public SistemaNecessidadeJogadores(JogadorRepository jogadorRepository, SessaoRepository sessaoRepository) {
        this.jogadorRepository = jogadorRepository;
        this.sessaoRepository = sessaoRepository;
    }

    @Scheduled(fixedDelay = 1000)
    public void reduzirNecessidadesDosJogadores() {
    }


}
