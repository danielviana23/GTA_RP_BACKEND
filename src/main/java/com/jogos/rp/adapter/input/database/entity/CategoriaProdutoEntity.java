package com.jogos.rp.adapter.input.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class CategoriaProdutoEntity {

    public CategoriaProdutoEntity(){}

    @Id
    @Column(name = "ID_PRODUTO", unique = true)
    private String idProduto;

    @Column(name = "NOME_CATEGORIA_PRODUTO")
    private String nomeCategoriaProduto;

}
