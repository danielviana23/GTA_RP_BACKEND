package com.jogos.rp.schaduler.sistema_pagamento;

import com.jogos.rp.adapter.input.database.entity.JogadorEntity;
import com.jogos.rp.adapter.input.database.entity.SessaoEntity;
import com.jogos.rp.adapter.input.database.entity.emprego.EmpregoEntity;
import com.jogos.rp.adapter.input.database.repository.jogador.JogadorRepository;
import com.jogos.rp.adapter.input.database.repository.jogador.sessao.SessaoRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class SistemaPagamento {

    private JogadorRepository jogadorRepository;
    private SessaoRepository sessaoRepository;

    public SistemaPagamento(JogadorRepository jogadorRepository, SessaoRepository sessaoRepository) {
        this.jogadorRepository = jogadorRepository;
        this.sessaoRepository = sessaoRepository;
    }


    @Transactional
    @Scheduled(fixedDelay = 10000)
    public void pagarJogadores() throws Exception {
        System.out.println("INICIANDO PAGAMENTO PARA OS JOGADORES");
        Optional<SessaoEntity> sessaoAtual = this.sessaoRepository.findById(1);
        if(sessaoAtual.isPresent()) {
            List<JogadorEntity> jogadoresNaSessao = sessaoAtual.get().getJogadores();
            if(!jogadoresNaSessao.isEmpty()) {
                for (JogadorEntity jogadorNaSessao: jogadoresNaSessao) {
                    EmpregoEntity empregoJogador = jogadorNaSessao.getEmprego();
                    if(!(empregoJogador == null)) {
                        BigDecimal salario = empregoJogador.getSalario();
                        Optional<JogadorEntity> jogador = this.jogadorRepository.findById(jogadorNaSessao.getIdJogador());

                        if (jogador.isPresent()) {
                            if (!(salario == null)) {
                                jogador.get().setDinheiro(jogador.get().getDinheiro().add(salario));
                                this.jogadorRepository.save(jogador.get());
                                System.out.println("PAGAMENTO PARA OO JOGADOR ID " + jogador.get().getIdJogador() + " FOI REALIZADO COM SUCESSO");
                            }
                        } else {
                            throw new Exception("Houve um problema com pagamento do jogador ID " + jogador.get().getIdJogador());
                        }
                    }
                }
            } else {
                System.out.println("NAO HÁ JOGADORES NA SESSÃO");
            }
        } else {
            System.out.println("NÃO EXISTE SESSÃO ATIVA NO MOMENTO!");
        }
    }
}
