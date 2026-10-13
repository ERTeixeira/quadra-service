package com.ERTeixeira.quadra_service.application.mapper;

import com.ERTeixeira.quadra_service.application.handler.command.AtualizarQuadraCommand;
import com.ERTeixeira.quadra_service.application.handler.command.CriarQuadraCommand;
import com.ERTeixeira.quadra_service.application.model.Quadra;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface QuadraMapper {

    @Mapping(target = "id", ignore = true)
    Quadra toEntity(CriarQuadraCommand command);

    @Mapping(target = "id", ignore = true)
    void updateEntity(AtualizarQuadraCommand command, @MappingTarget Quadra quadra);
}
