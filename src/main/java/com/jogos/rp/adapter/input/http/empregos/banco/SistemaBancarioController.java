package com.jogos.rp.adapter.input.http.empregos.banco;

import com.jogos.rp.adapter.input.database.repository.jogador.JogadorRepository;
import com.jogos.rp.adapter.input.http.dto.TransferenciaDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/banco")
public class SistemaBancarioController {

    private JogadorRepository jogadorRepository;

    public SistemaBancarioController(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    @PostMapping("/jogador/transferir_dinheiro")
    public void transferirDinherio(@RequestBody TransferenciaDto transferencia) {


    }
}
