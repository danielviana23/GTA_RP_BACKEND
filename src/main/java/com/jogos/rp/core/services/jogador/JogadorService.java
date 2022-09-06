package com.jogos.rp.core.services.jogador;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jogos.rp.adapter.input.database.entity.JogadorEntity;
import com.jogos.rp.adapter.input.database.entity.LoginEntity;
import com.jogos.rp.adapter.input.database.entity.emprego.EmpregoEntity;
import com.jogos.rp.adapter.input.database.repository.emprego.EmpregoRepository;
import com.jogos.rp.adapter.input.database.repository.jogador.JogadorRepository;
import com.jogos.rp.adapter.input.http.dto.JogadorDto;
import com.jogos.rp.core.port.jogador.JogadorInterface;
import com.jogos.rp.core.port.jogador.JogadorModel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class JogadorService implements JogadorInterface {

    private JogadorRepository jogadorRepository;
    private EmpregoRepository empregoRepository;

    public JogadorService(
            JogadorRepository jogadorRepository,
            EmpregoRepository empregoRepository){
        this.jogadorRepository = jogadorRepository;
        this.empregoRepository = empregoRepository;
    }

    @Override
    public Integer criarJogador(String jogadorModel) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JogadorDto jogadorDto = mapper.readValue(jogadorModel, JogadorDto.class);

        Integer cpf = new Random().nextInt(500 * 1000000000);

        LoginEntity login = LoginEntity.builder()
                .idControle(cpf)
                .gamertag(jogadorDto.getGamertag())
                .senha(jogadorDto.getSenha())
        .build();

        JogadorEntity jogadorEntity = JogadorEntity.builder()
                .idControle(cpf)
                .cpf(cpf)
                .gamerTag(jogadorDto.getGamertag())
                .login(login)
                .dinheiro(new BigDecimal("200"))
                .sono(100)
                .vida(100)
                .sede(100)
                .fome(100)
                .produtos(null)
                .veiculos(null)
                .nomeJogador("a")
                .isJogadorPreso(false)
                .armas(null)
        .build();

        this.jogadorRepository.save(jogadorEntity);

        return jogadorEntity.getCpf();
    }

    @Override
    public void deletarJogador(JogadorModel jogadorModel) {

    }

    @Override
    public List<JogadorEntity> buscarJogadores() {
        List<JogadorEntity> jogadoresCadastrados = this.jogadorRepository.findAll();

        if(jogadoresCadastrados.isEmpty()) {
            return null;
        }

        return jogadoresCadastrados;
    }

    @Override
    public JogadorEntity buscarJogador(JogadorModel jogadorModel) {
        Optional<JogadorEntity> jogadorCadastrado = this.jogadorRepository.buscarPorCpf(jogadorModel.getCpf());

        if(!jogadorCadastrado.isPresent()) {
            return null;
        }

        return jogadorCadastrado.get();
    }

    @Override
    public boolean atualizarEmpregoJogador(JogadorModel jogadorModel, Integer idEmprego) {
        JogadorEntity entity = this.buscarJogador(jogadorModel);
        Optional<EmpregoEntity> empregoNovo = this.empregoRepository.findById(idEmprego);

        if(empregoNovo.isPresent() && entity != null) {
            entity.setEmprego(empregoNovo.get());
            this.jogadorRepository.save(entity);
            return true;
        }

        return false;
    }

}
