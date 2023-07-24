package com.jornada.api.dto.destinos;

import java.math.BigDecimal;

public record DadosAtualizacaoDestino(Long id, String nome, String destinoImgUrl, BigDecimal preco) {
}
