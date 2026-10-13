package com.ERTeixeira.quadra_service.api.dto.input;

import com.ERTeixeira.quadra_service.application.model.TipoQuadra;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record QuadraInput(
        @NotBlank(message = "É obrigatório")
        @Size(max = 255, message = "Deve ter no máximo 255 caracteres")
        String nome,

        @NotNull(message = "É obrigatório")
        Boolean disponibilidade,

        @NotBlank(message = "É obrigatório")
        @Size(max = 255, message = "Deve ter no máximo 255 caracteres")
        String local,

        @NotNull(message = "É obrigatório")
        TipoQuadra tipo
) {
}
