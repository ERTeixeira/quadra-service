package com.ERTeixeira.quadra_service.api.dto.input;

import com.ERTeixeira.quadra_service.application.model.TipoQuadra;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record QuadraInput(
        @NotBlank(message = "é obrigatório")
        @Size(max = 255, message = "deve ter no máximo 255 caracteres")
        String nome,

        @NotNull(message = "é obrigatório")
        Boolean disponibilidade,

        @NotBlank(message = "é obrigatório")
        @Size(max = 255, message = "deve ter no máximo 255 caracteres")
        String local,

        @NotNull(message = "é obrigatório")
        TipoQuadra tipo
) {
}
