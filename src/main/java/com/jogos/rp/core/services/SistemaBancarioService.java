package com.jogos.rp.core.services;

import com.jogos.rp.adapter.input.database.entity.JogadorEntity;
import com.jogos.rp.adapter.input.database.repository.jogador.JogadorRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
public class SistemaBancarioService {

    private JogadorRepository jogadorRepository;

    public SistemaBancarioService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public void transferirDinheiro(UUID jogadorOrigemDinheiro, BigDecimal dinheiroATransferir, UUID jogadorDestinoDinheiro) {
        Optional<JogadorEntity> origemDinheiro = this.jogadorRepository.findById(jogadorOrigemDinheiro);
        Optional<JogadorEntity> destinoDinheiro = this.jogadorRepository.findById(jogadorDestinoDinheiro);

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
