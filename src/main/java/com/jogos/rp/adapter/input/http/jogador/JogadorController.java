package com.jogos.rp.adapter.input.http.jogador;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jogos.rp.adapter.input.database.entity.JogadorEntity;
import com.jogos.rp.adapter.input.database.entity.LoginEntity;
import com.jogos.rp.adapter.input.database.repository.emprego.EmpregoRepository;
import com.jogos.rp.adapter.input.database.repository.jogador.JogadorRepository;
import com.jogos.rp.adapter.input.database.repository.jogador.sessao.SessaoRepository;
import com.jogos.rp.adapter.input.http.dto.JogadorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/criar_jogador")
    public ResponseEntity<?> criarJogador(@RequestBody String modelJogador) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        JogadorDto jogadorDto = mapper.readValue(modelJogador, JogadorDto.class);

        Integer cpf = new Random().nextInt(500 * 1000000000);
//        UUID idControle = UUID.randomUUID();
        Integer idControle = cpf * 50;

        LoginEntity login = LoginEntity.builder()
                .idControle(idControle)
                .gamertag(jogadorDto.getGamertag())
                .senha(jogadorDto.getSenha())
        .build();

        JogadorEntity jogadorEntity = JogadorEntity.builder()
                .idControle(idControle)
                .cpf(cpf)
                .gamerTag(jogadorDto.getGamertag())
                .login(login)
                .dinheiro(new BigDecimal("200"))
                .sono(100)
                .vida(100)
                .sede(100)
                .fome(100)
                .produtos(null)
                .veiculos(null)
                .nicknameJogador("a")
                .isJogadorPreso(false)
                .armas(null)
        .build();

        this.jogadorRepository.save(jogadorEntity);
        ResponseEntity resp = ResponseEntity.status(201)
                .body("Jogador " + jogadorEntity.getCpf() +  " criado com sucesso!");

        return resp;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/buscar_jogadores")
    public ResponseEntity<?> buscarJogadores() {
        List<JogadorEntity> jogadoresCadastrados = this.jogadorRepository.findAll();

        if(jogadoresCadastrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(200)
                .body(jogadoresCadastrados);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/buscar_jogador/{id_jogador}")
    public ResponseEntity<?> buscarJogador(@PathVariable(name = "id_jogador") Integer cpf) {
        Optional<JogadorEntity> jogadorCadastrado = this.jogadorRepository.buscarPorCpf(cpf);

        if(!jogadorCadastrado.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(200)
                .body(jogadorCadastrado);
    }
}