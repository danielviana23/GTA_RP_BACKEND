package com.jogos.rp.adapter.input.http.jogador;

import com.jogos.rp.adapter.input.database.entity.JogadorEntity;
import com.jogos.rp.adapter.input.database.entity.SessaoEntity;
import com.jogos.rp.adapter.input.database.entity.emprego.EmpregoEntity;
import com.jogos.rp.adapter.input.database.repository.emprego.EmpregoRepository;
import com.jogos.rp.adapter.input.database.repository.jogador.JogadorRepository;
import com.jogos.rp.adapter.input.database.repository.jogador.sessao.SessaoRepository;
import com.jogos.rp.adapter.input.http.dto.JogadorEmpregoDto;
import com.jogos.rp.model.PlayerModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    private JogadorRepository jogadorRepository;
    private SessaoRepository sessaoRepository;
    private EmpregoRepository empregoRepository;

    private JogadorController(
            JogadorRepository jogadorRepository,
            SessaoRepository sessaoRepository,
            EmpregoRepository empregoRepository) {
       this.jogadorRepository = jogadorRepository;
       this.sessaoRepository = sessaoRepository;
       this.empregoRepository = empregoRepository;
    }

    @PostMapping("/criar_jogador")
    public ResponseEntity<?> criarJogador(@RequestBody PlayerModel modelJogador) {

        JogadorEntity jogadorEntity = JogadorEntity.builder()
                .idJogador(new Random().nextInt(500 * 1000000000))
                .dinheiro(new BigDecimal("200"))
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
        return ResponseEntity.status(201).body("Jogador " + jogadorEntity.getIdJogador() +  " criado com sucesso!");
    }

    @GetMapping("/buscar_jogadores")
    public ResponseEntity<?> buscarJogadores() {
        List<JogadorEntity> jogadoresCadastrados = this.jogadorRepository.findAll();

        if(jogadoresCadastrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(jogadoresCadastrados);

    }

    @GetMapping("/buscar_jogador/{id_jogador}")
    public ResponseEntity<?> buscarJogador(@PathVariable(name = "id_jogador") Integer id_jogador) {
        Optional<JogadorEntity> jogadorCadastrado = this.jogadorRepository.findById(id_jogador);

        if(!jogadorCadastrado.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(200).body(jogadorCadastrado);
    }
}