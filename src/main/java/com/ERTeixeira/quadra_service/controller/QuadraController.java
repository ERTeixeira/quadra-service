package com.ERTeixeira.quadra_service.controller;

import com.ERTeixeira.quadra_service.model.Quadra;
import com.ERTeixeira.quadra_service.repository.QuadraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quadras")
public class QuadraController {

    @Autowired
    private QuadraRepository quadraRepository;

    @GetMapping
    public List<Quadra> getAllQuadras() {
        return quadraRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuadraById(@PathVariable Long id) {
        return quadraRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Quadra createQuadra(@RequestBody Quadra quadra) {
        return quadraRepository.save(quadra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateQuadra(@PathVariable Long id, @RequestBody Quadra quadraDetails) {
        Quadra quadra = quadraRepository.findById(id).orElse(null);
        if (quadra == null) {
            return ResponseEntity.notFound().build();
        }

        quadra.setNome(quadraDetails.getNome());
        quadra.setDisponibilidade(quadraDetails.isDisponibilidade());
        quadra.setLocal(quadraDetails.getLocal());
        quadra.setTipo(quadraDetails.getTipo());
        Quadra updatedQuadra = quadraRepository.save(quadra);
        return ResponseEntity.ok(updatedQuadra);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuadra(@PathVariable Long id) {
        if (quadraRepository.existsById(id)) {
            quadraRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}