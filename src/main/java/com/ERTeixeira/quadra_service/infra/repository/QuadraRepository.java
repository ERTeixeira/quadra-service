package com.ERTeixeira.quadra_service.infra.repository;

import com.ERTeixeira.quadra_service.application.handler.query.QuadraView;
import com.ERTeixeira.quadra_service.application.model.Quadra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuadraRepository extends JpaRepository<Quadra, Long> {

    List<QuadraView> findAllProjectedBy();

    Optional<QuadraView> findProjectedById(Long id);

    boolean existsByNomeAndLocal(String nome, String local);

    boolean existsByNomeAndLocalAndIdNot(String nome, String local, Long id);
}
