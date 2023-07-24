package com.jornada.api.entity;

import com.jornada.api.dto.depoimentos.DadosAtualizacaoDepoimento;
import com.jornada.api.dto.destinos.DadosAtualizacaoDestino;
import com.jornada.api.dto.destinos.DadosCadastroDestino;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "destino")
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String destinoImgUrl;

    private BigDecimal preco;

    public Destino() {
    }

    public Destino(Long id, String nome, String destinoImgUrl, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.destinoImgUrl = destinoImgUrl;
        this.preco = preco;
    }

    public Destino(DadosCadastroDestino dados) {
        this.nome = dados.nome();
        this.destinoImgUrl = dados.destinoImgUrl();
        this.preco = dados.preco();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDestinoImgUrl() {
        return destinoImgUrl;
    }

    public void setDestinoImgUrl(String destinoImgUrl) {
        this.destinoImgUrl = destinoImgUrl;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destino destino = (Destino) o;
        return getId().equals(destino.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public void atualizarDestino(DadosAtualizacaoDestino dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.destinoImgUrl() != null) {
            this.destinoImgUrl = dados.destinoImgUrl();
        }
        if(dados.preco() != null) {
            this.preco = dados.preco();
        }
    }
}
