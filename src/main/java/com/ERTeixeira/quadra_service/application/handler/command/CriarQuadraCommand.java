package com.ERTeixeira.quadra_service.application.handler.command;

import com.ERTeixeira.quadra_service.application.model.TipoQuadra;

public record CriarQuadraCommand(
        String nome,
        boolean disponibilidade,
        String local,
        TipoQuadra tipo
) {
}
