package com.jogos.rp.adapter.input.http.sessao;

import com.jogos.rp.adapter.input.database.entity.JogadorEntity;
import com.jogos.rp.adapter.input.database.entity.SessaoEntity;
import com.jogos.rp.adapter.input.database.repository.jogador.JogadorRepository;
import com.jogos.rp.adapter.input.database.repository.jogador.sessao.SessaoRepository;
import com.jogos.rp.adapter.input.http.dto.JogadorSessaoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/sessao")
public class SessaoController {

    private SessaoRepository sessaoRepository;
    private JogadorRepository jogadorRepository;

    public SessaoController(SessaoRepository sessaoRepository, JogadorRepository jogadorRepository) {
        this.sessaoRepository = sessaoRepository;
        this.jogadorRepository = jogadorRepository;
    }

    @PostMapping("/criar_sessao/{id_sessao}")
    public void criarSessao(@PathVariable(name = "id_sessao") Integer id_sessao) {
        // todo criar sessao apenas se nao existir uma com mesmo id
        SessaoEntity sessao = SessaoEntity.builder().idSessao(id_sessao).build();
        this.sessaoRepository.save(sessao);
    }

    @GetMapping("/buscar_sessoes")
    public ResponseEntity<?> buscarSessoes() {
        List<SessaoEntity> sessoes = this.sessaoRepository.findAll();

        return ResponseEntity.ok().body(sessoes);
    }

    @PostMapping("/inserir_jogador_na_sessao")
    public ResponseEntity<?> inserirJogadorNaSessao(@RequestBody JogadorSessaoDto jogador) {
        Optional<SessaoEntity> sessao = this.sessaoRepository.findById(jogador.getId_sessao());
        if(sessao.isPresent()) {
            Optional<JogadorEntity> jogadorEntity = this.jogadorRepository.findById(UUID.fromString(jogador.getId_jogador()));
            if(!(jogadorEntity.isPresent())) {
                return ResponseEntity.status(404).body("Jogador não cadastrado! Cadastre-se antes de entrar na sessão");
            }

            sessao.get().getJogadores().add(jogadorEntity.get());
            this.sessaoRepository.save(sessao.get());
            return ResponseEntity.ok().body("Você entrou na sessão! Divirta-se!");
        }

        return ResponseEntity.badRequest().body("Sessão não está disponível");
    }

    @PostMapping("/remover_jogador_da_sessao")
    public ResponseEntity<?> removerJogadorDaSessao(@RequestBody JogadorSessaoDto jogador) {
        Optional<SessaoEntity> sessao = this.sessaoRepository.findById(jogador.getId_sessao());
        if(sessao.isPresent()) {

            List<JogadorEntity> jogadoresNaSessao = sessao.get().getJogadores();

            for (JogadorEntity jogadorAtivo: jogadoresNaSessao) {
                if(jogadorAtivo.getIdJogador().equals(UUID.fromString(jogador.getId_jogador()))) {
                    jogadoresNaSessao.remove(jogadorAtivo);
                    this.sessaoRepository.save(sessao.get());
                    return ResponseEntity.ok().body("Jogador removido da sessão com sucesso!");
                }
            }

        }

        return ResponseEntity.badRequest().body("Jogador não pôde ser removido!");
    }
}
