package com.metrosp.repository;

import com.metrosp.model.Vertice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerticeRepository extends JpaRepository<Vertice, Long> {
    Vertice findByDado(String dado);
}
