package com.jogos.rp.adapter.input.database.repository.jogador;

import com.jogos.rp.adapter.input.database.entity.JogadorEntity;
import com.jogos.rp.model.PlayerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JogadorRepository extends JpaRepository<JogadorEntity, UUID> {

}
