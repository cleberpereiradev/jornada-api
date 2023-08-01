package com.jornada.api.service;

import com.jornada.api.dto.destinos.DadosAtualizacaoDestino;
import com.jornada.api.dto.destinos.DadosListagemDestino;
import com.jornada.api.entity.Destino;
import com.jornada.api.infra.exception.DestinoNaoEncontradoException;
import com.jornada.api.repository.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

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

    public Optional<Destino> searchByNome(String nome) throws DestinoNaoEncontradoException{
        var destinos = destinoRepository.findAll();
        Long id = null;
        for(Destino destino : destinos) {
            if (destino.getNome().toLowerCase().contains(nome.toLowerCase())){
                id = destino.getId();
            } else {
                throw new DestinoNaoEncontradoException("Nenhum destino foi encontrado");
            }
        }
        var destinoEncontado = destinoRepository.findById(id);
        return destinoEncontado;
    }
}
