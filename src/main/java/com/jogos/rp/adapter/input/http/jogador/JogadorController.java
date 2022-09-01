package com.jogos.rp.adapter.input.http.jogador;

import com.jogos.rp.adapter.input.database.entity.JogadorEntity;
import com.jogos.rp.adapter.input.database.entity.SessaoEntity;
import com.jogos.rp.adapter.input.database.repository.jogador.JogadorRepository;
import com.jogos.rp.adapter.input.database.repository.jogador.sessao.SessaoRepository;
import com.jogos.rp.model.PlayerModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    private JogadorRepository jogadorRepository;
    private SessaoRepository sessaoRepository;


    private JogadorController(
            JogadorRepository jogadorRepository,
            SessaoRepository sessaoRepository) {
       this.jogadorRepository = jogadorRepository;
       this.sessaoRepository = sessaoRepository;
    }

    @PostMapping("/criar_jogador")
    public void criarJogador(@RequestBody PlayerModel modelJogador) {

        JogadorEntity jogadorEntity = JogadorEntity.builder()
                .idJogador(UUID.randomUUID())
                .sono(100)
                .vida(100)
                .sede(100)
                .fome(100)
                .produtos(null)
                .veiculos(null)
                .nicknameJogador(modelJogador.getNickname())
                .isJogadorPreso(false)
                .armas(null)
        .build();

        this.jogadorRepository.save(jogadorEntity);
    }

    @GetMapping("/buscar_jogadores")
    public ResponseEntity<?> buscarJogadores() {
        List<JogadorEntity> jogadoresCadastrados = this.jogadorRepository.findAll();

        if(jogadoresCadastrados.isEmpty()) {
            return ResponseEntity.badRequest().body("Nenhum jogador cadastrado");
        }

        return ResponseEntity.ok(jogadoresCadastrados);

    }

    @GetMapping("/buscar_jogador/{id_jogador}")
    public ResponseEntity<?> buscarJogador(@PathVariable(name = "id_jogador") String id_jogador) {
        Optional<JogadorEntity> jogadorCadastrado = this.jogadorRepository.findById(UUID.fromString(id_jogador));

        if(!jogadorCadastrado.isPresent()) {
            return ResponseEntity.badRequest().body("Nenhum jogador cadastrado");
        }

        return ResponseEntity.ok(jogadorCadastrado);

    }
}