package com.jogos.rp.core.sessao;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class SessaoRP {

    @Scheduled(fixedDelay = 10000)
    public void inserirJogadorNaSessao() {

    }

}
