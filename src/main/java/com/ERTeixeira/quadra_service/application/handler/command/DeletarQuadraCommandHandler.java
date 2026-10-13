package com.ERTeixeira.quadra_service.application.handler.command;

import com.ERTeixeira.quadra_service.application.exception.QuadraNaoEncontradaException;
import com.ERTeixeira.quadra_service.infra.repository.QuadraRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DeletarQuadraCommandHandler {

    private final QuadraRepository quadraRepository;

    public DeletarQuadraCommandHandler(QuadraRepository quadraRepository) {
        this.quadraRepository = quadraRepository;
    }

    @Transactional
    public void handle(Long id) {
        if (!quadraRepository.existsById(id)) {
            throw new QuadraNaoEncontradaException(id);
        }

        quadraRepository.deleteById(id);
    }
}
