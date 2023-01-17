package com.cce.challenge.repository;

import com.cce.challenge.repository.entity.Agente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenteRepository extends JpaRepository<Agente,Long> {
}
