package com.ERTeixeira.quadra_service.application.exception;

public class QuadraJaExisteException extends RuntimeException {

    public QuadraJaExisteException(String nome, String local) {
        super("Já existe uma quadra com o nome '" + nome + "' em '" + local + "'");
    }
}
