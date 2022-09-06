package com.jogos.rp.core.port.policia;

import com.jogos.rp.adapter.input.database.entity.JogadorEntity;
import com.jogos.rp.core.port.jogador.JogadorModel;

public interface PoliciaPortInterface {

    JogadorEntity consultarCpf(JogadorModel model);
}
