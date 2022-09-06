package com.jogos.rp.adapter.input.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jogos.rp.adapter.input.http.dto.MensagemRetornoDto;
import com.jogos.rp.core.services.ocorrencia.OcorrenciaService;
import com.jogos.rp.model.ocorrencia.OcorrenciaModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

    private OcorrenciaService ocorrenciaService;
    public OcorrenciaController(OcorrenciaService ocorrenciaService) {
        this.ocorrenciaService = ocorrenciaService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/gerar_ocorrencia")
    public ResponseEntity<?> gerarEventoOcorrencia(@RequestBody String ocorrencia) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        OcorrenciaModel ocorrenciaModel = mapper.readValue(ocorrencia, OcorrenciaModel.class);

        try {
            this.ocorrenciaService.gerarEventoOcorrencia(ocorrenciaModel);
            return ResponseEntity.status(200).body(MensagemRetornoDto.builder().mensagemRetorno("Ocorrencia criada com sucesso").build());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("Não foi possível gerar ocorrência");
        }

    }
}
