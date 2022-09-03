package com.jogos.rp.adapter.input.database.repository.login;

import com.jogos.rp.adapter.input.database.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {


    @Query(value = "SELECT * FROM LOGIN WHERE gamertag=?1 AND senha=?2", nativeQuery = true)
    Optional<LoginEntity> buscarLogin(String gamertag, String senha);
}
