package com.jogos.rp.adapter.input.http.autenticacao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class LoginErrorDto {

    public LoginErrorDto(){}

    private String messageLoginErro;
}
