package com.jogos.rp.adapter.input.database.repository.delegacia.prisao;

public interface PrisaoRepository {

    void prenderJogador(Integer idJogadorPreso);
    void soltarJogador(Integer idJogadorPreso);
}
