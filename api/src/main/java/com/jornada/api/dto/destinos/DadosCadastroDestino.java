package com.jornada.api.dto.destinos;

import com.jornada.api.entity.Destino;

import java.math.BigDecimal;

public record DadosCadastroDestino(String nome, String destinoImgUrl, BigDecimal preco) {

}
