package com.jornada.api.entity;

import com.jornada.api.dto.DadosAtualizacaoDepoimento;
import com.jornada.api.dto.DadosCadastroDepoimento;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "depoimentos")
public class Depoimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(columnDefinition = "TEXT", name = "depoimento")
    private String textoDepoimento;

    private String imgUrl;

    public Depoimento() {
    }

    public Depoimento(Long id, String nome, String textoDepoimento, String imgUrl) {
        this.id = id;
        this.nome = nome;
        this.textoDepoimento = textoDepoimento;
        this.imgUrl = imgUrl;
    }

    public Depoimento(DadosCadastroDepoimento dados) {
        this.nome = dados.nome();
        this.textoDepoimento = dados.textoDepoimento();
        this.imgUrl = dados.imgUrl();
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

    public String getTextoDepoimento() {
        return textoDepoimento;
    }

    public void setTextoDepoimento(String textoDepoimento) {
        this.textoDepoimento = textoDepoimento;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depoimento that = (Depoimento) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public void atualizarDepoimento(DadosAtualizacaoDepoimento dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.textoDepoimento() != null) {
            this.textoDepoimento = dados.textoDepoimento();
        }
        if(dados.imgUrl() != null) {
            this.imgUrl = dados.imgUrl();
        }
    }
}
