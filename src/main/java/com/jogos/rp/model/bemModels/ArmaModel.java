package com.jogos.rp.model.bemModels;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
@Setter
public class ArmaModel {

    private String nome;
    private MultipartFile fotoArma;
    private String preco;

}
