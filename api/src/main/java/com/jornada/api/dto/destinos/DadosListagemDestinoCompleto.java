package com.jornada.api.dto.destinos;

import com.jornada.api.entity.Destino;

import java.math.BigDecimal;

public record DadosListagemDestinoCompleto(Long id, String nome, String destinoImgUrl, BigDecimal preco) {

    public DadosListagemDestinoCompleto(Destino destino) {
        this(destino.getId(), destino.getNome(), destino.getDestinoImgUrl(), destino.getPreco());
    }
}
