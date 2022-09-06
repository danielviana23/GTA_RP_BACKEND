package com.jogos.rp.adapter.input.http.autenticacao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jogos.rp.adapter.input.database.entity.LoginEntity;
import com.jogos.rp.adapter.input.database.repository.jogador.JogadorRepository;
import com.jogos.rp.adapter.input.database.repository.login.LoginRepository;
import com.jogos.rp.adapter.input.database.repository.registro.EmailRepository;
import com.jogos.rp.adapter.input.http.dto.LoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {

    private JogadorRepository jogadorRepository;
    private EmailRepository emailRepository;
    private LoginRepository loginRepository;

    public AutenticacaoController(
            JogadorRepository jogadorRepository,
            EmailRepository emailRepository,
            LoginRepository loginRepository) {
        this.jogadorRepository = jogadorRepository;
        this.emailRepository = emailRepository;
        this.loginRepository = loginRepository;
    }

    @CrossOrigin(
            origins = "*"
    )
    @PostMapping("/login")
    public ResponseEntity<?> logar(@RequestBody String loginDto) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        LoginDto loginObj = mapper.readValue(loginDto, LoginDto.class);

        String gamertag = loginObj.getUsuario();
        String senha = loginObj.getSenha();

        Optional<LoginEntity> loginEntity = loginRepository.buscarLogin(gamertag, senha);
        if(loginEntity.isPresent()) {
            return ResponseEntity.ok().body(TokenDto.builder().token(loginEntity.get().getIdControle()).build());
        }

        return ResponseEntity.status(404)
                .body(LoginErrorDto.builder().messageLoginErro("Jogador não encontrado").build());
    }
}
