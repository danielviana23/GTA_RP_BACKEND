package com.jogos.rp.adapter.input.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@Table(name = "LOGIN")
public class LoginEntity {

    public LoginEntity(){}

    @Id
    @Column(name = "ID")
    private Integer idControle;

    @Column(name = "GAMERTAG", unique = true)
    private String gamertag;

    @Column(name = "SENHA")
    private String senha;
}
