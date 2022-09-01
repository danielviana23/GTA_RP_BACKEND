package com.jogos.rp.adapter.input.http.empregos.policial;

import com.jogos.rp.adapter.input.http.dto.PrisaoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emprego/policial")
public class PolicialController {

    @PostMapping("/prender_jogador")
    public ResponseEntity<?> prenderJogador(@RequestBody PrisaoDTO prisaoDTO) {
        // inserir id do jogador na tabela de prisão
        // atualizar status de prisao do jogador para true
        return ResponseEntity.ok(prisaoDTO);
    }
}
