package com.ERTeixeira.quadra_service.application.exception;

public class QuadraNaoEncontradaException extends RuntimeException {

    public QuadraNaoEncontradaException(Long id) {
        super("Quadra não encontrada: " + id);
    }
}
