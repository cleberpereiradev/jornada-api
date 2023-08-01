package com.jornada.api.infra.exception;

public class DestinoNaoEncontradoException extends RuntimeException {

    public DestinoNaoEncontradoException(String msg) {
        super(msg);
    }
}
