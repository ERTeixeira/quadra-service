package com.ERTeixeira.quadra_service.application.handler.command;

import com.ERTeixeira.quadra_service.application.exception.QuadraJaExisteException;
import com.ERTeixeira.quadra_service.application.exception.QuadraNaoEncontradaException;
import com.ERTeixeira.quadra_service.application.mapper.QuadraMapper;
import com.ERTeixeira.quadra_service.application.model.Quadra;
import com.ERTeixeira.quadra_service.infra.repository.QuadraRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AtualizarQuadraCommandHandler {

    private final QuadraRepository quadraRepository;
    private final QuadraMapper quadraMapper;

    public AtualizarQuadraCommandHandler(QuadraRepository quadraRepository, QuadraMapper quadraMapper) {
        this.quadraRepository = quadraRepository;
        this.quadraMapper = quadraMapper;
    }

    @Transactional
    public Quadra handle(AtualizarQuadraCommand command) {
        Quadra quadra = quadraRepository.findById(command.id())
                .orElseThrow(() -> new QuadraNaoEncontradaException(command.id()));

        if (quadraRepository.existsByNomeAndLocalAndIdNot(command.nome(), command.local(), command.id())) {
            throw new QuadraJaExisteException(command.nome(), command.local());
        }

        quadraMapper.updateEntity(command, quadra);
        return quadraRepository.save(quadra);
    }
}
