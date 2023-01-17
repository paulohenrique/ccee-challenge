package com.cce.challenge.repository;

import com.cce.challenge.repository.entity.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao,Long> {

    List<Regiao> findRegiaoBySigla(String sigla);
}
