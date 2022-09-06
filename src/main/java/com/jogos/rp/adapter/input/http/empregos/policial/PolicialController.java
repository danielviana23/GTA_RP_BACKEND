package com.jogos.rp.adapter.input.http.empregos.policial;

import com.jogos.rp.adapter.input.database.entity.JogadorEntity;
import com.jogos.rp.adapter.input.http.dto.PrisaoDTO;
import com.jogos.rp.core.port.jogador.JogadorModel;
import com.jogos.rp.core.services.jogador.JogadorService;
import com.jogos.rp.core.services.policia.PolicialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emprego/policial")
public class PolicialController {

    private PolicialService policialService;

    @PostMapping("/consultar_cpf/{cpf_cidadao}")
    public ResponseEntity<?> prenderJogador(@PathVariable("cpf_cidadao") String cpf) {

        JogadorEntity jogador = this.policialService.consultarCpf(JogadorModel.builder().cpf(Integer.getInteger(cpf)).build());
        if(jogador == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jogador);
        }
        return ResponseEntity.ok(jogador);
    }
}
