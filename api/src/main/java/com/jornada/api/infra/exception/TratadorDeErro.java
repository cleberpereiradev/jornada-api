package com.jornada.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.apache.catalina.authenticator.BasicAuthenticator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class TratadorDeErro {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratadorErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratadorErro400(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(DadosErroValidacao::new).toList());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity tratadorErro400(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

//    @ExceptionHandler(BadCredentialsException.class)
//    public ResponseEntity tratarErroBadCredentials() {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
//    }

//    @ExceptionHandler(AuthenticationException.class)
//    public ResponseEntity tratarErroAuthentication() {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha na autenticação");
//    }
//
//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity tratarErroAcessoNegado() {
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso negado");
//    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity tratarErro500(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + ex.getLocalizedMessage());
    }

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity tratarErroValidacao(ValidacaoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


    private record DadosErroValidacao(String campo, String mensagem) {
        public DadosErroValidacao(FieldError error) {
            this(error.getField(),error.getDefaultMessage());
        }
    }
}