package com.jogos.rp.adapter.input.database.repository.jogador;

import com.jogos.rp.adapter.input.database.entity.JogadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface JogadorRepository extends JpaRepository<JogadorEntity, Integer> {

    @Query(value = "SELECT * FROM JOGADOR WHERE cpf = ?1", nativeQuery = true)
    Optional<JogadorEntity> buscarPorCpf(Integer cpf);
}
