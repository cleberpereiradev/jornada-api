package com.jornada.api.dto;

import com.jornada.api.entity.Depoimento;
import jakarta.persistence.Column;

public class DepoimentoDTO {

    private Long id;
    private String nome;
    private String textoDepoimento;
    private String imgUrl;

    public DepoimentoDTO(Depoimento entity) {
        id = entity.getId();
        nome = entity.getNome();
        textoDepoimento = entity.getTextoDepoimento();
        imgUrl = entity.getImgUrl();
    }

    public DepoimentoDTO(Long id, String textoDepoimento, String nome, String imgUrl) {
        this.id = id;
        this.textoDepoimento = textoDepoimento;
        this.nome = nome;
        this.imgUrl = imgUrl;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTextoDepoimento(String textoDepoimento) {
        this.textoDepoimento = textoDepoimento;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTextoDepoimento() {
        return textoDepoimento;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
