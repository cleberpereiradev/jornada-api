package com.jornada.api.service;

import com.jornada.api.dto.DadosAtualizacaoDepoimento;
import com.jornada.api.dto.DadosDetalhamentoDepoimento;
import com.jornada.api.dto.DadosListagemDepoimento;
import com.jornada.api.entity.Depoimento;
import com.jornada.api.exception.IdNotFoundException;
import com.jornada.api.repository.DepoimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepoimentoService {
    @Autowired
    private DepoimentoRepository repository;

    public List<DadosListagemDepoimento> findAll() {
        return this.repository.findAll().stream().map(DadosListagemDepoimento::new).toList();
    }

    public DadosDetalhamentoDepoimento findById(Long id) {
        Depoimento depoimento = repository.findById(id).get();
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


    public List<DadosListagemDepoimento> findRandomDepoimentos() throws IdNotFoundException, InsufficientResourcesException {
        var lista = this.findAll();
        if(lista.size() < 3){
            throw new InsufficientResourcesException();
        }
        int max = lista.size() + 1;
        int min = Math.toIntExact(lista.get(0).id());
        System.out.println(min);
        List<Optional<Depoimento>> depoimentos = new ArrayList<>();
        if(lista.size() != 0) {
            List<Integer> listaIds = new ArrayList<>();
            while (listaIds.size() < 3){
                int index = sortearNumeros(min,max);
                if(!listaIds.contains(index)){
                    listaIds.add(index);
                }
            }
            try{
                for(Integer indice : listaIds){
                    Optional<Depoimento> depoimento = this.repository.findById(Long.valueOf(indice));
                    depoimentos.add(depoimento);
                }
            }catch (IdNotFoundException exception){
                exception.printStackTrace();
            }

        }
        List<DadosListagemDepoimento> res = depoimentos.stream().map(DadosListagemDepoimento::new).toList();
        return res;
    }

    private int sortearNumeros(int min,int max) {
        int random = (int) (Math.random() * (max - min) + min);
        return random;
    }
}
