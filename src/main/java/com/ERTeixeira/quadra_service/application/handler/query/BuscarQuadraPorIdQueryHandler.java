package com.ERTeixeira.quadra_service.application.handler.query;

import com.ERTeixeira.quadra_service.application.exception.QuadraNaoEncontradaException;
import com.ERTeixeira.quadra_service.infra.repository.QuadraRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BuscarQuadraPorIdQueryHandler {

    private final QuadraRepository quadraRepository;

    public BuscarQuadraPorIdQueryHandler(QuadraRepository quadraRepository) {
        this.quadraRepository = quadraRepository;
    }

    @Transactional(readOnly = true)
    public QuadraView handle(Long id) {
        return quadraRepository.findProjectedById(id)
                .orElseThrow(() -> new QuadraNaoEncontradaException(id));
    }
}
