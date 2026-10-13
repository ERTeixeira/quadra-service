package com.ERTeixeira.quadra_service.application.handler.query;

import com.ERTeixeira.quadra_service.infra.repository.QuadraRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ListarQuadrasQueryHandler {

    private final QuadraRepository quadraRepository;

    public ListarQuadrasQueryHandler(QuadraRepository quadraRepository) {
        this.quadraRepository = quadraRepository;
    }

    @Transactional(readOnly = true)
    public List<QuadraView> handle() {
        return quadraRepository.findAllProjectedBy();
    }
}
