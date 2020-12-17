package com.ifma.vinculotcc_api.repositories;

import java.util.Optional;

import com.ifma.vinculotcc_api.models.Professor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Iterable<Professor> findByNome(String nome);
    Iterable<Professor> findByArea(String area);
    Iterable<Professor> findByNomeContaining(String nome);


    @Query("SELECT p FROM Professor p WHERE p.matricula = ?1")
    Optional<Professor> buscarUmPorMatricula(String matricula);
    
}
