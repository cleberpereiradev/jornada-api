package com.jornada.api.service;

import com.jornada.api.dto.DepoimentoDTO;
import com.jornada.api.entity.Depoimento;
import com.jornada.api.repository.DepoimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepoimentoService {
    @Autowired
    private DepoimentoRepository repository;

    public List<DepoimentoDTO> findAll() {
        List<Depoimento> depoimentos = repository.findAll();

        return depoimentos.stream().map(DepoimentoDTO::new).toList();
    }

    public DepoimentoDTO save(Depoimento entity) {
        var depoimento = repository.save(entity);

        return depoimento.obterDepoimentoDTO();
    }

    public DepoimentoDTO findById(Long id) {
        var depoimento = repository.findById(id);
        return depoimento.get().obterDepoimentoDTO();
    }
}
