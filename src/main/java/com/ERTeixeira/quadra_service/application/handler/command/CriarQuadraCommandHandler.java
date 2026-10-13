package com.ERTeixeira.quadra_service.application.handler.command;

import com.ERTeixeira.quadra_service.application.exception.QuadraJaExisteException;
import com.ERTeixeira.quadra_service.application.mapper.QuadraMapper;
import com.ERTeixeira.quadra_service.application.model.Quadra;
import com.ERTeixeira.quadra_service.infra.repository.QuadraRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CriarQuadraCommandHandler {

    private final QuadraRepository quadraRepository;
    private final QuadraMapper quadraMapper;

    public CriarQuadraCommandHandler(QuadraRepository quadraRepository, QuadraMapper quadraMapper) {
        this.quadraRepository = quadraRepository;
        this.quadraMapper = quadraMapper;
    }

    @Transactional
    public Quadra handle(CriarQuadraCommand command) {
        if (quadraRepository.existsByNomeAndLocal(command.nome(), command.local())) {
            throw new QuadraJaExisteException(command.nome(), command.local());
        }

        Quadra quadra = quadraMapper.toEntity(command);
        return quadraRepository.save(quadra);
    }
}
