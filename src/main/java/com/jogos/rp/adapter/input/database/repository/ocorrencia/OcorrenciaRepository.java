package com.jogos.rp.adapter.input.database.repository.ocorrencia;

import com.jogos.rp.adapter.input.database.entity.OcorrenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcorrenciaRepository extends JpaRepository<OcorrenciaEntity, Integer> {
}
