package com.jornada.api.dto;

import com.jornada.api.entity.Depoimento;

import java.util.Optional;

public record DadosListagemDepoimento(Long id, String nome, String textoDepoimento, String imgUrl) {
    public DadosListagemDepoimento(Depoimento depoimento) {
        this(depoimento.getId(), depoimento.getNome(),depoimento.getTextoDepoimento(),depoimento.getImgUrl());
    }

    public DadosListagemDepoimento(Optional<Depoimento> depoimento) {
        this(depoimento.get().getId(),depoimento.get().getNome(),depoimento.get().getTextoDepoimento(),depoimento.get().getImgUrl());
    }
}