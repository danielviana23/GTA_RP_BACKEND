package com.jogos.rp.adapter.input.database.repository.registro;

import com.jogos.rp.adapter.input.database.entity.EmailEntity;
import com.jogos.rp.adapter.input.database.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, UUID> {

    Optional<EmailEntity> findByEmail(String email);


}
