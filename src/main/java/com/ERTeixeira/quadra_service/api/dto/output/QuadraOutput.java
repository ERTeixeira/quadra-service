package com.ERTeixeira.quadra_service.api.dto.output;

import com.ERTeixeira.quadra_service.application.model.TipoQuadra;

public record QuadraOutput(
        Long id,
        String nome,
        boolean disponibilidade,
        String local,
        TipoQuadra tipo
) {
}
