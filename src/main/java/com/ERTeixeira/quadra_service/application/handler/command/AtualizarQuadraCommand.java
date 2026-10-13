package com.ERTeixeira.quadra_service.application.handler.command;

import com.ERTeixeira.quadra_service.application.model.TipoQuadra;

public record AtualizarQuadraCommand(
        Long id,
        String nome,
        boolean disponibilidade,
        String local,
        TipoQuadra tipo
) {
}
