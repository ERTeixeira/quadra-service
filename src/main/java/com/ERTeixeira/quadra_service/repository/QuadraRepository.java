package com.ERTeixeira.quadra_service.repository;

import com.ERTeixeira.quadra_service.model.Quadra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuadraRepository extends JpaRepository<Quadra, Long> {
}