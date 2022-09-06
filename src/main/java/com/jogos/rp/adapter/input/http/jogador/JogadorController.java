package com.jogos.rp.adapter.input.http.jogador;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jogos.rp.adapter.input.database.entity.JogadorEntity;
import com.jogos.rp.adapter.input.database.entity.LoginEntity;
import com.jogos.rp.adapter.input.database.repository.emprego.EmpregoRepository;
import com.jogos.rp.adapter.input.database.repository.jogador.JogadorRepository;
import com.jogos.rp.adapter.input.database.repository.jogador.sessao.SessaoRepository;
import com.jogos.rp.adapter.input.http.dto.JogadorDto;
import com.jogos.rp.core.port.jogador.JogadorModel;
import com.jogos.rp.core.services.jogador.JogadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    private JogadorService jogadorService;

    private JogadorController(JogadorService jogadorService){
       this.jogadorService = jogadorService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/criar_jogador")
    public ResponseEntity<?> criarJogador(@RequestBody String modelJogador) throws JsonProcessingException {

        Integer cpf = this.jogadorService.criarJogador(modelJogador);

        return ResponseEntity.status(201).body("Jogador com CPF " + cpf + " foi criado com sucesso!");
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/buscar_jogadores")
    public ResponseEntity<?> buscarJogadores() {

        List<JogadorEntity> jogadoresEncontrados = this.jogadorService.buscarJogadores();
        if(jogadoresEncontrados.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jogadores não encontrados");
        }

        return ResponseEntity.status(200)
                .body(jogadoresEncontrados);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/buscar_jogador/{id_jogador}")
    public ResponseEntity<?> buscarJogador(@PathVariable(name = "id_jogador") Integer cpf) {

        JogadorEntity jogadorEntity =
                this.jogadorService.buscarJogador(JogadorModel.builder().cpf(cpf).build());


        if(jogadorEntity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jogador não encontrado");
        }

        return ResponseEntity.status(200).body(jogadorEntity);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/atualizar/emprego/{id_jogador}/{id_emprego}")
    public ResponseEntity<?> atualizarJogador(
            @PathVariable(name = "id_jogador") Integer cpf,
            @PathVariable(name = "id_emprego") Integer idEmprego
    ) {

        boolean isEmpregoAtualizado = this.jogadorService.atualizarEmpregoJogador(
                JogadorModel.builder().cpf(cpf).build(),
                idEmprego
        );

        if(isEmpregoAtualizado) {
            return ResponseEntity.status(200).body("Você está empregado!");
        } else {
            return ResponseEntity.status(400).body("Houve um problema ao empregá-lo. Tente um outro emprego");
        }

    }
}