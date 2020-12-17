package com.ifma.vinculotcc_api.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;

import com.ifma.vinculotcc_api.models.enums.PeriodoAluno;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_aluno;

    private String nome;
    private String sobrenome;
    private String matricula;
    private Long anoIngresso;
    private String nomeCurso;

    //@Enumerated(EnumType.STRING) // TODDO enum Periodo 
    @Enumerated(EnumType.ORDINAL)
    private PeriodoAluno periodo;

    @ManyToOne
    @JoinColumn(name = "id_tcc")
    private Tcc tcc;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Long getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(Long anoIngresso) {
        this.anoIngresso = anoIngresso;
    }
/*
    public String getNomeCurso() {
        return nomeCurso;
    }
*/
    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    @DecimalMin(value = "7", message = "Período não pode ser menor que setimo!")
    public Integer getPeriodo() {
        return periodo.getDescricao();
    }

    public void setPeriodo(PeriodoAluno periodo) {
        this.periodo = periodo;
    }

    public Tcc getTcc() {
        return tcc;
    }

    public void setTcc(Tcc tcc) {
        this.tcc = tcc;
    }

    public Long getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(Long id_aluno) {
        this.id_aluno = id_aluno;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_aluno == null) ? 0 : id_aluno.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        if (id_aluno == null) {
            if (other.id_aluno != null)
                return false;
        } else if (!id_aluno.equals(other.id_aluno))
            return false;
        return true;
    }

    
}
