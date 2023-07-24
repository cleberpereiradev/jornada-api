package com.jornada.api.service;

import com.jornada.api.dto.depoimentos.DadosAtualizacaoDepoimento;
import com.jornada.api.dto.destinos.DadosAtualizacaoDestino;
import com.jornada.api.dto.destinos.DadosCadastroDestino;
import com.jornada.api.dto.destinos.DadosListagemDestino;
import com.jornada.api.entity.Destino;
import com.jornada.api.infra.exception.IdNotFoundException;
import com.jornada.api.repository.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DestinoService {

    @Autowired
    private DestinoRepository destinoRepository;

    public List<DadosListagemDestino> findAll() {
        var destinos = this.destinoRepository.findAll();
        return destinos.stream().map(DadosListagemDestino::new).toList();
    }

    public void save(Destino destino) {
        this.destinoRepository.save(destino);
    }

    public void deleteById(Long id) {
        this.destinoRepository.deleteById(id);
    }

    public void update(@RequestBody DadosAtualizacaoDestino dados) {
        var destino = destinoRepository.getReferenceById(dados.id());
        destino.atualizarDestino(dados);
    }
}
