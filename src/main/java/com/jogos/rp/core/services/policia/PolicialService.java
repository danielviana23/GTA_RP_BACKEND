package com.jogos.rp.core.services.policia;

import com.jogos.rp.adapter.input.database.entity.JogadorEntity;
import com.jogos.rp.adapter.input.http.empregos.policial.PolicialController;
import com.jogos.rp.core.port.jogador.JogadorModel;
import com.jogos.rp.core.port.policia.PoliciaPortInterface;
import com.jogos.rp.core.services.jogador.JogadorService;
import org.springframework.stereotype.Service;

@Service
public class PolicialService implements PoliciaPortInterface {

    private JogadorService jogadorService;

    public PolicialService(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @Override
    public JogadorEntity consultarCpf(JogadorModel jogadorModel) {
        JogadorEntity jogadorEntity = this.jogadorService.buscarJogador(jogadorModel);
        if(jogadorEntity == null) {
            return null;
        }
        return jogadorEntity;
    }

}
