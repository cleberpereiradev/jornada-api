package com.jornada.api.dto.destinos;

import com.jornada.api.dto.depoimentos.DadosAtualizacaoDepoimento;
import com.jornada.api.entity.Depoimento;
import com.jornada.api.entity.Destino;

import java.math.BigDecimal;

public record DadosDetalhamentoDestino(Long id, String nome, String destinoImgUrl, BigDecimal preco) {

    public DadosDetalhamentoDestino(Destino destino) {
        this(destino.getId(), destino.getNome(), destino.getDestinoImgUrl(), destino.getPreco());
    }

    public DadosDetalhamentoDestino(DadosAtualizacaoDestino dados) {
        this(dados.id(), dados.nome(), dados.destinoImgUrl(), dados.preco());
    }

}
