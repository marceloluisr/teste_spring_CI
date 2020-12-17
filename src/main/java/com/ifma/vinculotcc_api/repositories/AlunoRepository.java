package com.ifma.vinculotcc_api.repositories;

import java.util.Optional;

import com.ifma.vinculotcc_api.models.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
     Iterable<Aluno> findByNome(String nome);
     
     /*
     @Query("SELECT a FROM Aluno a WHERE a.tcc.id_tcc = ?1")
     Optional<Aluno> findAlunoTccById(Long id);
     */

     @Query("SELECT a FROM Aluno a WHERE a.matricula = ?1")
	Optional<Aluno> buscarUmPorMatricula(String matricula);

}
