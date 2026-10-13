package com.ERTeixeira.quadra_service.api.mapper;

import com.ERTeixeira.quadra_service.api.dto.input.QuadraInput;
import com.ERTeixeira.quadra_service.api.dto.output.QuadraOutput;
import com.ERTeixeira.quadra_service.application.handler.command.AtualizarQuadraCommand;
import com.ERTeixeira.quadra_service.application.handler.command.CriarQuadraCommand;
import com.ERTeixeira.quadra_service.application.handler.query.QuadraView;
import com.ERTeixeira.quadra_service.application.model.Quadra;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface QuadraApiMapper {

    CriarQuadraCommand toCriarCommand(QuadraInput input);

    @Mapping(target = "id", source = "id")
    AtualizarQuadraCommand toAtualizarCommand(Long id, QuadraInput input);

    QuadraOutput toOutput(Quadra quadra);

    QuadraOutput toOutput(QuadraView view);

    List<QuadraOutput> toOutputList(List<QuadraView> views);
}
