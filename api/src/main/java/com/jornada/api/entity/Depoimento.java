package com.jornada.api.entity;

import jakarta.persistence.*;

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
}
