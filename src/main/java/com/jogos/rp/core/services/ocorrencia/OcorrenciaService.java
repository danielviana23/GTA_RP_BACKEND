package com.jogos.rp.core.services.ocorrencia;

import com.jogos.rp.adapter.input.database.entity.OcorrenciaEntity;
import com.jogos.rp.adapter.input.database.repository.ocorrencia.OcorrenciaRepository;
import com.jogos.rp.core.port.ocorrencia.OcorrenciaPortInterface;
import com.jogos.rp.model.ocorrencia.OcorrenciaModel;
import org.springframework.stereotype.Service;

@Service
public class OcorrenciaService implements OcorrenciaPortInterface {

    private OcorrenciaRepository ocorrenciaRepository;
    public OcorrenciaService(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    @Override
    public void gerarEventoOcorrencia(OcorrenciaModel ocorrenciaModel) {

        OcorrenciaEntity ocorrencia = OcorrenciaEntity.builder()
                .idJogadorOcorrencia(ocorrenciaModel.getCpfJogadorOcorrencia())
                .idNumeroEmergencia(ocorrenciaModel.getNumeroChamado())
                .descricaoOcorrencia(ocorrenciaModel.getDescricaoOcorrencia())
        .build();

        this.ocorrenciaRepository.save(ocorrencia);
    }
}
