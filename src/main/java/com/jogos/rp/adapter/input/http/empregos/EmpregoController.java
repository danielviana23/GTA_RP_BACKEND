package com.jogos.rp.adapter.input.http.empregos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jogos.rp.adapter.input.database.entity.JogadorEntity;
import com.jogos.rp.adapter.input.database.entity.emprego.EmpregoEntity;
import com.jogos.rp.adapter.input.database.repository.emprego.EmpregoRepository;
import com.jogos.rp.adapter.input.database.repository.jogador.JogadorRepository;
import com.jogos.rp.adapter.input.http.dto.JogadorEmpregoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/emprego")
public class EmpregoController {

    private EmpregoRepository empregoRepository;
    private JogadorRepository jogadorRepository;

    public EmpregoController(EmpregoRepository empregoRepository, JogadorRepository jogadorRepository) {
        this.empregoRepository = empregoRepository;
        this.jogadorRepository = jogadorRepository;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/buscar_empregos")
    public ResponseEntity<?> buscarEmpregos() {
        return ResponseEntity.ok(this.empregoRepository.findAll());
    }

    @PostMapping("/criar_emprego")
    public void criarEmprego() {
        EmpregoEntity entity = EmpregoEntity.builder().nomeEmprego("POLICIAL").id(1)
                .salario(new BigDecimal(1000)).build();

        this.empregoRepository.save(entity);
    }

    @PostMapping("/associar_emprego_jogador")
    public ResponseEntity<?> empregarJogador(@RequestBody String jogadorEmpregoDto) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        JogadorEmpregoDto jogadorEmprego= mapper.readValue(jogadorEmpregoDto, JogadorEmpregoDto.class);
        Optional<JogadorEntity> jogadorEncontrado = this.jogadorRepository.buscarPorCpf(jogadorEmprego.getId_jogador());
        if(jogadorEncontrado.isPresent()) {
            Optional<EmpregoEntity> emprego = this.empregoRepository.findById(jogadorEmprego.getId_emprego());
            if(emprego.isPresent()) {
                jogadorEncontrado.get().setEmprego(emprego.get());
                this.jogadorRepository.save(jogadorEncontrado.get());
                return ResponseEntity.ok("Você está empregado!");
            }
            return ResponseEntity.ok("Emprego não encontrado! Selecione outro emprego!");
        }

        return ResponseEntity.ok("Não foi possível te empregar! Tente outro emprego.");
    }
}
