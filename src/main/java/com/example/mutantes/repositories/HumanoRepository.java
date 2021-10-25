package com.example.mutantes.repositories;

import com.example.mutantes.entities.Humano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HumanoRepository extends JpaRepository<Humano, Long> {

    @Query(value = "SELECT * FROM humano h WHERE h.es_mutante = false", nativeQuery = true)
    List<Humano> findAllByNoEsMutante();

    @Query(value = "SELECT * FROM humano h WHERE h.es_mutante = true", nativeQuery = true)
    List<Humano> findAllByEsMutante();


}
