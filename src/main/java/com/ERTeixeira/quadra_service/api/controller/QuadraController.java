package com.ERTeixeira.quadra_service.api.controller;

import com.ERTeixeira.quadra_service.api.dto.input.QuadraInput;
import com.ERTeixeira.quadra_service.api.dto.output.QuadraOutput;
import com.ERTeixeira.quadra_service.api.mapper.QuadraApiMapper;
import com.ERTeixeira.quadra_service.application.handler.command.AtualizarQuadraCommandHandler;
import com.ERTeixeira.quadra_service.application.handler.command.CriarQuadraCommandHandler;
import com.ERTeixeira.quadra_service.application.handler.command.DeletarQuadraCommandHandler;
import com.ERTeixeira.quadra_service.application.handler.query.BuscarQuadraPorIdQueryHandler;
import com.ERTeixeira.quadra_service.application.handler.query.ListarQuadrasQueryHandler;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quadras")
public class QuadraController {

    private final ListarQuadrasQueryHandler listarQuadrasQueryHandler;
    private final BuscarQuadraPorIdQueryHandler buscarQuadraPorIdQueryHandler;
    private final CriarQuadraCommandHandler criarQuadraCommandHandler;
    private final AtualizarQuadraCommandHandler atualizarQuadraCommandHandler;
    private final DeletarQuadraCommandHandler deletarQuadraCommandHandler;
    private final QuadraApiMapper quadraApiMapper;

    public QuadraController(ListarQuadrasQueryHandler listarQuadrasQueryHandler,
                            BuscarQuadraPorIdQueryHandler buscarQuadraPorIdQueryHandler,
                            CriarQuadraCommandHandler criarQuadraCommandHandler,
                            AtualizarQuadraCommandHandler atualizarQuadraCommandHandler,
                            DeletarQuadraCommandHandler deletarQuadraCommandHandler,
                            QuadraApiMapper quadraApiMapper) {
        this.listarQuadrasQueryHandler = listarQuadrasQueryHandler;
        this.buscarQuadraPorIdQueryHandler = buscarQuadraPorIdQueryHandler;
        this.criarQuadraCommandHandler = criarQuadraCommandHandler;
        this.atualizarQuadraCommandHandler = atualizarQuadraCommandHandler;
        this.deletarQuadraCommandHandler = deletarQuadraCommandHandler;
        this.quadraApiMapper = quadraApiMapper;
    }

    @GetMapping
    public List<QuadraOutput> getAllQuadras() {
        return quadraApiMapper.toOutputList(listarQuadrasQueryHandler.handle());
    }

    @GetMapping("/{id}")
    public QuadraOutput getQuadraById(@PathVariable Long id) {
        return quadraApiMapper.toOutput(buscarQuadraPorIdQueryHandler.handle(id));
    }

    @PostMapping
    public QuadraOutput createQuadra(@Valid @RequestBody QuadraInput input) {
        return quadraApiMapper.toOutput(criarQuadraCommandHandler.handle(quadraApiMapper.toCriarCommand(input)));
    }

    @PutMapping("/{id}")
    public QuadraOutput updateQuadra(@PathVariable Long id, @Valid @RequestBody QuadraInput input) {
        return quadraApiMapper.toOutput(atualizarQuadraCommandHandler.handle(quadraApiMapper.toAtualizarCommand(id, input)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuadra(@PathVariable Long id) {
        deletarQuadraCommandHandler.handle(id);
        return ResponseEntity.noContent().build();
    }
}
