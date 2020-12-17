package com.ifma.vinculotcc_api.service;
import java.util.Optional;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

import com.ifma.vinculotcc_api.models.Aluno;
import com.ifma.vinculotcc_api.repositories.AlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;
    
    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Transactional
    public Aluno salva(Aluno aluno) {
        return this.alunoRepository.save(aluno);
    }

    public Iterable<Aluno> todos() {
        return this.alunoRepository.findAll();
    }

    
    public Iterable<Aluno> buscarPorNome(String nome) {
        return this.alunoRepository.findByNome(nome);
    }

    public Optional<Aluno> buscarUmAlunoPorMatricula(String matricula) {
        return this.alunoRepository.buscarUmPorMatricula(matricula);
    }

    

    /*
     * Versão 1 public Cliente buscarPor(Long id) { return
     * clienteRepository.findById(id).get(); }
     */

    // Versão 2
    public Optional<Aluno> buscarPor(Long id) {
        return this.alunoRepository.findById(id);
    }

    @Transactional
    public void removePelo(Long id) {
        this.alunoRepository.deleteById(id);
    }
}
