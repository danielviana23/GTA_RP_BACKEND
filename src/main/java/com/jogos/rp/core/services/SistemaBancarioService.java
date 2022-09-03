package com.jogos.rp.core.services;

import com.jogos.rp.adapter.input.database.entity.JogadorEntity;
import com.jogos.rp.adapter.input.database.repository.jogador.JogadorRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class SistemaBancarioService {

    private JogadorRepository jogadorRepository;

    public SistemaBancarioService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public void transferirDinheiro(Integer cpfJogadorOrigemDinheiro, BigDecimal dinheiroATransferir, Integer cpfJogadorDestinoDinheiro) {
        Optional<JogadorEntity> origemDinheiro = this.jogadorRepository.buscarPorCpf(cpfJogadorOrigemDinheiro);
        Optional<JogadorEntity> destinoDinheiro = this.jogadorRepository.buscarPorCpf(cpfJogadorDestinoDinheiro);

//        if(origemDinheiro.isPresent() && destinoDinheiro.isPresent()) {
//            BigDecimal dinheiroOrigem = origemDinheiro.get().getDinheiro();
//            BigDecimal dinheiroDestino = destinoDinheiro.get().getDinheiro();
//
//            origemDinheiro.get().setDinheiro(origemDinheiro.get().getDinheiro() - dinheiroATransferir);
//
//        } else {
//
//        }
    }
}
