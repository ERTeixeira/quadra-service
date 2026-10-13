package com.ERTeixeira.quadra_service.application.handler.query;

import com.ERTeixeira.quadra_service.application.model.TipoQuadra;

public record QuadraView(
        Long id,
        String nome,
        boolean disponibilidade,
        String local,
        TipoQuadra tipo
) {
}
