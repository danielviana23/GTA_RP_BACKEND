package com.jogos.rp.adapter.input.http.empregos;

import com.jogos.rp.adapter.input.database.entity.emprego.EmpregoEntity;
import com.jogos.rp.adapter.input.database.repository.emprego.EmpregoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/emprego")
public class EmpregoController {

    private EmpregoRepository empregoRepository;

    public EmpregoController(EmpregoRepository empregoRepository) {
        this.empregoRepository = empregoRepository;
    }

    @PostMapping("/criar_emprego")
    public void criarEmprego() {
        EmpregoEntity entity = EmpregoEntity.builder().nomeEmprego("POLICIAL").id(1)
                .salario(new BigDecimal(1000)).build();

        this.empregoRepository.save(entity);
    }
}
