package com.jornada.api.service;

import com.jornada.api.dto.depoimentos.DadosAtualizacaoDepoimento;
import com.jornada.api.dto.depoimentos.DadosDetalhamentoDepoimento;
import com.jornada.api.dto.depoimentos.DadosListagemDepoimento;
import com.jornada.api.entity.Depoimento;
import com.jornada.api.infra.exception.IdNotFoundException;
import com.jornada.api.repository.DepoimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepoimentoService {
    @Autowired
    private DepoimentoRepository repository;

    public List<DadosListagemDepoimento> findAll() {
        return this.repository.findAll().stream().map(DadosListagemDepoimento::new).toList();
    }

    public DadosDetalhamentoDepoimento findById(Long id) {
        var depoimento = repository.getReferenceById(id);
        return new DadosDetalhamentoDepoimento(depoimento);

    }

    public void save(Depoimento dados) {
        repository.save(dados);
    }


    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void update(@RequestBody DadosAtualizacaoDepoimento dados) throws IdNotFoundException {
            var depoimento = repository.getReferenceById(dados.id());
            depoimento.atualizarDepoimento(dados);
    }


    public List<DadosListagemDepoimento> findRandomDepoimentos() {
        var lista = this.findAll();
        if(lista.size() < 3){
            throw new RuntimeException();
        }
        int max = lista.size();
        List<DadosListagemDepoimento> depoimentos = new ArrayList<>();
        if(lista.size() != 0) {
            List<Integer> listaIds = new ArrayList<>();
            while (depoimentos.size() < 3){
                int index = sortearNumeros(max);
                if(!listaIds.contains(index)){
                    DadosListagemDepoimento depo = lista.get(index);
                    depoimentos.add(depo);
                    listaIds.add(index);
                }
            }
        }
        List<DadosListagemDepoimento> res = depoimentos.stream().map(DadosListagemDepoimento::new).toList();
        return res;
    }

    private int sortearNumeros(int max) {
        int random = (int) (Math.random() * (max));
        return random;
    }
}
