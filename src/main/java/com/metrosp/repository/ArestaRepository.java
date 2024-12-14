package com.metrosp.repository;

import com.metrosp.model.Aresta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArestaRepository extends JpaRepository<Aresta, Long> {
}
