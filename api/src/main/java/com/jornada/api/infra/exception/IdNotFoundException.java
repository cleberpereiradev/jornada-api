package com.jornada.api.infra.exception;

public class IdNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public IdNotFoundException(Long id) {
        super(String.format("ID: %s não encontrado!",id));
    }
}
